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
package ch.hslu.sw12.quicksort;

import ch.hslu.sw12.array.init.RandomInitTask;
import ch.hslu.sw12.array.sum.SumTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.sw12.quicksort.DemoQuicksort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoQuicksort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 500_000_000;
        final int[] array = new int[size];

        final ForkJoinPool pool = new ForkJoinPool();
        RandomInitTask initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);

        SumTask sumTask = new SumTask(array);
        long result = pool.invoke(sumTask);
        LOG.debug("Init. Checksum : " + result);

        final QuicksortTask sortTask = new QuicksortTask(array);
        long time1 = System.currentTimeMillis();
        pool.invoke(sortTask);
        long time2 = System.currentTimeMillis();
        LOG.info("QuicksortTask  : " + (time2 - time1) / 1000 + " sec");

        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Conc. Checksum : " + result);

        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);

        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Init. Checksum : " + result);

        long time3 = System.currentTimeMillis();
        QuicksortRecursive.quicksort(array);
        long time4 = System.currentTimeMillis();
        LOG.info("QuicksortRec.  : " + (time4 - time3) / 1000 + " sec");

        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Recu. Checksum : " + result);

        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);

        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Init. checksum : " + result);

        long time5 = System.currentTimeMillis();
        Arrays.sort(array);
        long time6 = System.currentTimeMillis();
        LOG.info("Arrays.sort    : " + (time6 - time5) / 1000 + " sec");

        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Sort checksum  : " + result);
    }
}
