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

import ch.hslu.sw08.buffer.Buffer;

import java.util.ArrayDeque;
import java.util.concurrent.*;

/**
 * Puffer mit einer begrenzten Kapazität. Der Puffer ist thread sicher.
 *
 * @param <T> Elememente des Buffers
 */
public final class BoundedBufferAdapter<T> implements Buffer<T> {

    private final LinkedBlockingDeque<T> queue;
    private final Semaphore putSema;
    private final Semaphore takeSema;
    private int maxSize;
    private int size;

    /**
     * Erzeugt einen Puffer mit bestimmter Kapazität.
     *
     * @param n Kapazität des Puffers
     */
    public BoundedBufferAdapter(final int n) {
        maxSize = n;
        queue = new LinkedBlockingDeque<>(maxSize);
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
        if (!putSema.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
            return null;
        }
        T elem;
        synchronized (queue) {
            elem = queue.removeLast();
            size--;
        }
        putSema.release();
        return elem;
    }

    @Override
    public T first() throws InterruptedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T last() throws InterruptedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean empty() {
        if (this.queue.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean full() {
        if (this.queue.size() == this.maxSize) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return this.size;
    }
}
