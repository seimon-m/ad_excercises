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
    private static int n = 1;

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

        ExecutorService threadpool = Executors.newCachedThreadPool();
        List<Callable<BigInteger>> tasks = new ArrayList<>();
        int nTasks = 100;
        for (int i = 0; i < nTasks; i++) {
            tasks.add(new RandomPrime());
        }

        CompletionService<BigInteger> completionService = new ExecutorCompletionService<>(threadpool);
        tasks.forEach(completionService::submit);

        try {
            for (int i = 0; i < tasks.size(); i++) {
                Future<BigInteger> future = completionService.take();
                if (future.get() != BigInteger.ZERO) {
                    LOG.info(n + ": " + future.get().toString().substring(0, 20) + "...");
                    n++;
                } else {
                    LOG.info("Task " + i + " : No prime");
                }
                if (n > 100) {
                    threadpool.shutdown();
                }

            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


//        int n = 1;
//        while (n <= 100) {
//            BigInteger bi = new BigInteger(1024, new Random());
//            if (bi.isProbablePrime(Integer.MAX_VALUE)) {
//                LOG.info(n + ": " + bi.toString().substring(0, 20) + "...");
//                n++;
//            }
//        }
    }
}
