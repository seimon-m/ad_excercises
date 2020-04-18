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

/**
 * Thread-sicherer Zähler.
 */
public final class SynchronizedCounter implements Counter {

    private int counter = 0;
    private final Object lock = new Object();

    /**
     * Erzeugt einen Zähler mit Zählerstand 0.
     */
    public SynchronizedCounter() {
    }

    /**
     * see ch.hslu.ad.exercise.sw07.count.Counter#increment()
     */
    @Override
    public void increment() {
        synchronized (lock) {
            counter++;
        }
    }

    /**
     * see ch.hslu.ad.exercise.sw07.count.Counter#decrement()
     */
    @Override
    public void decrement() {
        synchronized (lock) {
            counter--;
        }
    }

    /**
     * see ch.hslu.ad.exercise.sw07.count.Counter#get()
     */
    @Override
    public int get() {
        synchronized (lock) {
            return this.counter;
        }
    }
}
