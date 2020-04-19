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

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Produzent, der eine maximale Anzahl Werte produziert und diese in eine Queue speichert.
 */
public final class Producer implements Callable<Long> {

    private final BlockingQueue<Integer> queue;
    private final int maxRange;

    /**
     * Erzeugt einen Produzent, der eine bestimmte Anzahl Integer-Werte produziert.
     *
     * @param queue Queue zum Speichern der Integer-Werte.
     * @param max   Anzahl Integer-Werte.
     */
    public Producer(final BlockingQueue<Integer> queue, final int max) {
        this.queue = queue;
        this.maxRange = max;
    }

    /**
     * Liefert die Summe aller zusammengezählter Integer Werte.
     *
     * @return Summe.
     * @throws Exception falls Ausnahmen passieren.
     */
    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = 1; i <= maxRange; i++) {
            sum += i;
            queue.add(i);
        }
        return sum;
    }
}
