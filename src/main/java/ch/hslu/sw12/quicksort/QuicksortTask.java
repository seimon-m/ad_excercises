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

import java.util.concurrent.RecursiveAction;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class QuicksortTask extends RecursiveAction {

    private static final int THRESHOLD = 5;
    private final int[] array;
    private final int min;
    private final int max;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    private QuicksortTask(final int[] array, final int min, final int max) {
        this.array = array;
        this.min = min;
        this.max = max;
    }

    @Override
    protected void compute() {
        if ((max - min) < THRESHOLD) {
            QuicksortRecursive.insertionSort(array, min, max);
        } else {
            int up = min;                 // linke Grenze
            int down = max - 1;           // rechte Grenze (ohne Pivot)
            int t = array[max];              // rechtes Element als Pivot
            boolean allChecked = false;
            do {
                while (array[up] < t) {
                    up++;                   // suche grösseres (>=) Element von links
                }
                while ((array[down] > t) && (down > up)) {
                    down--;                 // suche kleineres (<=) Element von rechts an
                }
                if (down > up) {            // solange keine Überschneidung
                    exchange(array, up, down);
                    up++;                   // linke und rechte Grenze verschieben
                    down--;
                } else {
                    allChecked = true;      // Austausch beendet
                }
            } while (!allChecked);
            exchange(array, up, max);         // Trennelement an endgültige Position (a[up)

            QuicksortTask left = null;
            if (min < (up - 1)) {          // linke Hälfte
                left = new QuicksortTask(array, min, (up - 1));
                left.fork();
            }
            QuicksortTask right = null;
            if ((up + 1) < max) {         // rechte Hälfte, ohne Pivot
                right = new QuicksortTask(array, (up + 1), max);
                right.fork();
            }

            if (left != null) {
                left.join();
            }
            if (right != null) {
                right.join();
            }
        }
    }

    private static final void exchange(final int[] a, final int firstIndex, final int secondIndex) {
        int tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

}
