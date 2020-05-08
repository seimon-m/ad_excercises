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
package ch.hslu.sw12.mergesort;

import ch.hslu.sw12.array.init.RandomInitTask;
import ch.hslu.sw12.array.sum.SumTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ForkJoinPool;

/**
 * Performance Vergleich der Mergesort-Implementation.
 */
public final class DemoMergesort {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.sw12.mergesort.DemoMergesort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoMergesort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 300_000_000;
        final int[] array = new int[size];
        LOG.info("THRESHOLD = 1000");

        /* Array befüllen */
        final ForkJoinPool pool = new ForkJoinPool();
        RandomInitTask initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);

        /* Array aufsummieren (Checksumme 1) */
        SumTask sumTask = new SumTask(array);
        long result = pool.invoke(sumTask);
        LOG.debug("Init Checksum 1          : " + result);

        /* Sortieren mit nebenläufigem Mergesort */
        final MergesortTask sortTask = new MergesortTask(array);
        long time1 = System.currentTimeMillis();
        pool.invoke(sortTask);
        long time2 = System.currentTimeMillis();
        LOG.info("Time conc. Mergesort     : " + (time2 - time1) / 1000 + " sec");

        /* Array erneut aufsummieren (Checksumme 1) */
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Mergesort Checksum 1     : " + result);

        /* Array neu befüllen */
        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);

        /* Array aufsummieren (Checksumme 2) */
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Init Checksum 2          : " + result);

        /* Sortieren mit synchronem Mergesort */
        long time3 = System.currentTimeMillis();
        MergesortRecursive.mergeSort(array);
        long time4 = System.currentTimeMillis();
        LOG.info("Time normal Mergesort    : " + (time4 - time3) / 1000 + " sec");

        /* Array erneut aufsummieren (Checksumme 2) */
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.debug("Mergesort Checksum 2     : " + result);
    }
}
