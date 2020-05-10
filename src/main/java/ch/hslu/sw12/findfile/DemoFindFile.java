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
import java.util.concurrent.ForkJoinPool;

/**
 * Codevorlage für eine Dateisuche.
 */
public final class DemoFindFile {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.sw12.findfile.DemoFindFile.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFindFile() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final String search = "findMe.rtf";
        final File rootDir = new File(System.getProperty("user.home"));
//        final File rootDir = new File("/Users/simon/Documents");

//        LOG.info("Start searching " + search + " recurive in " + rootDir);
//        long time1 = System.currentTimeMillis();
//        FindFile.findFile(search, rootDir);
//        long time2 = System.currentTimeMillis();
//        LOG.info("Found in " + (time2 - time1) + "ms");

        LOG.info("Start searching " + search + " concurrent in " + rootDir);
        final ForkJoinPool pool = new ForkJoinPool();
        final FindFileTask root = new FindFileTask(search, rootDir);
        long time3 = System.currentTimeMillis();
        LOG.info(pool.invoke(root));
        long time4 = System.currentTimeMillis();
        LOG.info("Found in " + (time4 - time3) + "ms");
    }
}