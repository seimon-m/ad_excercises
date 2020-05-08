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
package ch.hslu.sw12.fibo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ForkJoinPool;

/**
 * Codevorlage für die Verwendung von RecursiveTask mit einem Fork-Join-Pool.
 */
public final class DemoFibonacciCalc {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.sw12.fibo.DemoFibonacciCalc.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFibonacciCalc() {
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboIterative(final int n) {
        long f = 0;
        long g = 1;
        for (int i = 1; i <= n; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboRecursive(final int n) {
        return n > 1 ? fiboRecursive(n - 1) + fiboRecursive(n - 2) : n;
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int n = 44;
        LOG.info("fibo(" + n + ") start...");

        final ForkJoinPool pool = new ForkJoinPool();
        final FibonacciTask task1 = new FibonacciTask(n);
        long time1 = System.currentTimeMillis();
        long result = pool.invoke(task1);
        long time2 = System.currentTimeMillis();
        LOG.info("Conc. recursive = " + result);
        LOG.info("Conc. recursive : " + (time2 - time1) + " msec");

        final ForkJoinPool commonPool = ForkJoinPool.commonPool();
        final FibonacciTask task2 = new FibonacciTask(n);
        time1 = System.currentTimeMillis();
        result = commonPool.invoke(task2);
        time2 = System.currentTimeMillis();
        LOG.info("Conc. rec. common = " + result);
        LOG.info("Conc. rec. common : " + (time2 - time1) + " msec");

        time1 = System.currentTimeMillis();
        result = fiboIterative(n);
        time2 = System.currentTimeMillis();
        LOG.info("Single iterative = " + result);
        LOG.info("Single iterative : " + (time2 - time1) + " msec");

        time1 = System.currentTimeMillis();
        result = fiboRecursive(n);
        time2 = System.currentTimeMillis();
        LOG.info("Single recursive = " + result);
        LOG.info("Single recursive : " + (time2 - time1) + " msec");
    }
}
