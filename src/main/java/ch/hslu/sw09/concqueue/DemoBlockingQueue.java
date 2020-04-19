/*
 * Copyright 2020 Hochschule Luzern - Informatik.
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
package ch.hslu.sw09.concqueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.*;

/**
 * Demonstration einer synchrnisierten List mit n Producer und m Consumer.
 */
public final class DemoBlockingQueue {

    private static final Logger LOG = LogManager.getLogger(DemoBlockingQueue.class);

    /**
     * Privater Konstruktor.
     */
    private DemoBlockingQueue() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     * @throws ExecutionException   bei Excecution-Fehler.
     */
    public static void main(final String args[]) throws InterruptedException, ExecutionException {

        long time1 = System.currentTimeMillis();

        final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        final ExecutorService executor = Executors.newCachedThreadPool();
        final List<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            futures.add(executor.submit(new Producer(queue, 1000)));
        }
        Iterator<Future<Long>> iterator = futures.iterator();
        long totProd = 0;
        while (iterator.hasNext()) {
            long sum = iterator.next().get();
            totProd += sum;
            LOG.info("prod sum = " + sum);
        }
        LOG.info("prod tot = " + totProd);
        long totCons = executor.submit(new Consumer(queue)).get();
        LOG.info("cons tot = " + totCons);
        executor.shutdown();

        long time2 = System.currentTimeMillis();
        LOG.info("Time: " + (time2 - time1));
    }
}
