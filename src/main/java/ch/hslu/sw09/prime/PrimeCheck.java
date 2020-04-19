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
package ch.hslu.sw09.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 100 grosse Primzahlen produzieren.
 */
public final class PrimeCheck {

    private static final Logger LOG = LogManager.getLogger(PrimeCheck.class);
    private static int nPrimes = 1;

    /**
     * Privater Konstruktor.
     */
    public PrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {

        long time1 = System.currentTimeMillis();

        final int requiredPrimes = 100;
        ExecutorService threadpool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        List<Callable<BigInteger>> tasks = new ArrayList<>();
        for (int i = 0; i < requiredPrimes; i++) {
            tasks.add(new RandomPrime());
        }

        CompletionService<BigInteger> completionService = new ExecutorCompletionService<>(threadpool);
        tasks.forEach(completionService::submit);

        try {
            for (int i = 0; i < tasks.size(); i++) {
                Future<BigInteger> future = completionService.take();
                LOG.info(nPrimes + ": " + future.get().toString().substring(0, 20) + "...");
                nPrimes++;
                if (nPrimes >= requiredPrimes) {
                    threadpool.shutdown();
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        long time2 = System.currentTimeMillis();
        LOG.info("Time: " + (time2 - time1));
    }
}
