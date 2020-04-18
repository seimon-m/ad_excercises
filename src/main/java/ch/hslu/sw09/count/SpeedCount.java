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
package ch.hslu.sw09.count;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Speed-Test für unterschiedlich impementierte Counters.
 */
public final class SpeedCount {

    private static final Logger LOG = LogManager.getLogger(SpeedCount.class);
    private static boolean counterCheck;

    /**
     * Privater Konstruktor.
     */
    private SpeedCount() {
    }

    /**
     * Test für einen Counter.
     *
     * @param counter Zählertyp.
     * @param counts  Anzahl Zähl-Vorgänge.
     * @param tester  Anzahl Tester-Threads.
     * @return Dauer des Tests in mSec.
     */
    public static long speedTest(Counter counter, int counts, int tester) {
        final ExecutorService executor = Executors.newCachedThreadPool();
        final List<Future<Integer>> futures = new ArrayList<>();
        long timer = System.currentTimeMillis();
        for (int i = 0; i < tester; i++) {
            futures.add(executor.submit(new CountTask(counter, counts)));
        }
        Iterator<Future<Integer>> iterator = futures.iterator();
        while (iterator.hasNext()) {
            try {
                if (iterator.next().get() == 0) {
                    counterCheck = true;
                }
            } catch (InterruptedException | ExecutionException ex) {
                LOG.debug(ex);
                return -1;
            }
        }
        long duration = System.currentTimeMillis() - timer;
        executor.shutdown();
        return duration;
    }

    /**
     * Main-Counter-Test.
     *
     * @param args not used.
     */
    public static void main(final String args[]) {
        final int passes = 23;
        final int tester = 20;
        final Counter counterSync = new SynchronizedCounter();
        long sum = 0;
        for (int i = 0; i < passes; i++) {
            counterCheck = false;
            sum += speedTest(counterSync, 1000000, tester);
            if (!counterCheck) {
                LOG.info("counter failed!");
            }
        }
        LOG.info("Sync counter average test duration = " + sum / passes + " ms");
        final Counter counterAtom = new AtomicCounter();
        sum = 0;
        for (int i = 0; i < passes; i++) {
            sum += speedTest(counterAtom, 1000000, tester);
        }
        LOG.info("Atom counter average test duration = " + sum / passes + " ms");
        if (counterCheck) {
            LOG.info("counter ok");
        }
    }
}
