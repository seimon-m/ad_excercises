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
package ch.hslu.sw08.buffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Puffer nach dem First In First Out Prinzip mit einer begrenzten Kapazität.
 * Der Puffer ist thread sicher.
 *
 * @param <T> Elememente des Buffers
 */
public final class BoundedBuffer<T> implements Buffer<T> {
    private static final Logger LOG = LogManager.getLogger(BoundedBuffer.class);
    private final ArrayDeque<T> queue;
    private final Semaphore putSema;
    private final Semaphore takeSema;
    private final int maxSize;
    private int size;

    /**
     * Erzeugt einen Puffer mit bestimmter Kapazität.
     *
     * @param n Kapazität des Puffers
     */
    public BoundedBuffer(final int n) {
        maxSize = n;
        queue = new ArrayDeque<>(maxSize);
        putSema = new Semaphore(n);
        takeSema = new Semaphore(0);
    }

    @Override
    public void put(final T elem) throws InterruptedException {
        putSema.acquire();
        synchronized (queue) {
            queue.addFirst(elem);
            size++;
        }
        takeSema.release();
    }

    @Override
    public T get() throws InterruptedException {
        takeSema.acquire();
        T elem;
        synchronized (queue) {
            elem = queue.removeLast();
            size--;
        }
        putSema.release();
        return elem;
    }

    @Override
    public boolean put(T elem, long millis) throws InterruptedException {
        if (putSema.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
            synchronized (queue) {
                queue.addFirst(elem);
                size++;
            }
            takeSema.release();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T get(long millis) throws InterruptedException {
        takeSema.acquire();
        T elem = null;
        synchronized (queue) {
            while (this.empty()) {
                this.wait(millis);
                if (this.empty()) {
                    LOG.debug("get time expired");
                    return elem;
                }
            }
            elem = queue.removeLast();
        }
        putSema.release();
        return elem;
    }

    @Override
    public T first() throws InterruptedException {
        if (queue.size() < 1) {
            throw new IndexOutOfBoundsException("The buffer is empty. Could not get first element.");
        }
        return queue.getFirst();
    }

    @Override
    public T last() throws InterruptedException {
        if (queue.size() < 1) {
            throw new IndexOutOfBoundsException("The buffer is empty. Could not get last element.");
        }
        return queue.getLast();
    }

    @Override
    public boolean empty() {
        return this.queue.isEmpty();
    }

    @Override
    public boolean full() {
        return this.queue.size() == this.maxSize;
    }

    @Override
    public int size() {
        return this.size;
    }
}
