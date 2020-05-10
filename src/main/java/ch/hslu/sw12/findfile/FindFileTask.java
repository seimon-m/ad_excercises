/*
 * Copyright 2020 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.sw12.findfile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Codevorlage zu CountedCompleter für eine Dateisuche.
 */
@SuppressWarnings("serial")
public final class FindFileTask extends CountedCompleter<String> {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.sw12.findfile.FindFileTask.class);

    private final String regex;
    private final File dir;
    private final AtomicReference<String> result;

    /**
     * Erzeugt eine File-Such-Aufgabe.
     *
     * @param regex Ausdruck der den Filenamen enthält.
     * @param dir   Verzeichnis in dem das File gesucht wird.
     */
    public FindFileTask(String regex, File dir) {
        this(null, regex, dir, new AtomicReference<>(null));
    }

    private FindFileTask(final CountedCompleter<?> parent, final String regex, final File dir, final AtomicReference<String> result) {
        super(parent);
        this.regex = regex;
        this.dir = dir;
        this.result = result;
    }

    @Override
    public void compute() {
        final File[] list = dir.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    this.addToPendingCount(1);
                    final FindFileTask task = new FindFileTask(regex, file);
                    task.fork();
                } else if (regex.equalsIgnoreCase(file.getName())) {
                    this.result.set(file.toString());
                    quietlyCompleteRoot();
                }
            }
        }
        tryComplete();
    }

    @Override
    public String getRawResult() {
        if (result != null) {
            return result.get();
        }
        return null;
    }
}
