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
package ch.hslu.sw09.buffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Demonstration des BoundedBuffers mit n Producer und m Consumer.
 */
public final class DemoBoundedBuffer {

    private static final Logger LOG = LogManager.getLogger(DemoBoundedBuffer.class);

    /**
     * Privater Konstruktor.
     */
    private DemoBoundedBuffer() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     */
    public static void main(final String args[]) throws InterruptedException, ExecutionException {
        final Random random = new Random();
        final int nPros = 3;
        final int mCons = 2;
        int sumCons = 0;
        int sumProd = 0;


        ArrayList<Consumer> consumers = new ArrayList<>();
        ArrayList<Producer> producers = new ArrayList<>();

        ArrayList<Future<Integer>> tasksProd = new ArrayList<>();
        ArrayList<Future<Integer>> tasksCons = new ArrayList<>();

        final ExecutorService executorProd = Executors.newCachedThreadPool();
        final ExecutorService executorCons = Executors.newCachedThreadPool();


        final BoundedBufferAdapter<Integer> queue = new BoundedBufferAdapter<>(50);

        for (int i = 0; i < nPros; i++) {
            producers.add(new Producer(queue, random.nextInt(10000)));
            tasksProd.add(executorProd.submit(producers.get(i)));
        }
        for (int i = 0; i < mCons; i++) {
            consumers.add(new Consumer(queue));
            tasksCons.add(executorCons.submit(consumers.get(i)));
        }

        TimeUnit.MILLISECONDS.sleep(100);

        // Erlange die Summe aller Produzenten. Wartet bis alle Produzenten fertig sind, daher blockierender Aufruf.
        for (Future<Integer> future : tasksProd) {
            sumProd += future.get();
        }

        // Setzte das run Flag von allen Konsumenten auf false.
        for (Consumer cons : consumers) {
            cons.setRunFalse();
        }

        // Beende die beiden ExecutorServices
        executorCons.shutdown();
        executorProd.shutdown();

        // Erlange die Summe aller Konsumenten.
        for (Future<Integer> future : tasksCons) {
            sumCons += future.get();
        }

        LOG.info("Produziert: " + sumProd + " | Konsumiert: " + sumCons + " | Differenz: " + (sumProd - sumCons));
        LOG.info("BoundenBuffer leer? " + queue.empty());
    }

}
