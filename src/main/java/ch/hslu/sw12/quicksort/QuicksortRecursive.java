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

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
public class QuicksortRecursive {

    /**
     * public method exposed to client, sorts given array using QuickSort
     * Algorithm in Java.
     *
     * @param a input array.
     */
    public static final void quicksort(final int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    /**
     * Recursive quicksort logic.
     *
     * @param a     input array.
     * @param left  start index of the array.
     * @param right end index of the array.
     */
    public static final void quicksort(final int[] a, final int left, final int right) {
        int up = left;                 // linke Grenze
        int down = right - 1;           // rechte Grenze (ohne Pivot)
        int t = a[right];              // rechtes Element als Pivot
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++;                   // suche grösseres (>=) Element von links
            }
            while ((a[down] > t) && (down > up)) {
                down--;                 // suche kleineres (<=) Element von rechts an
            }
            if (down > up) {            // solange keine Überschneidung
                exchange(a, up, down);
                up++;                   // linke und rechte Grenze verschieben
                down--;
            } else {
                allChecked = true;      // Austausch beendet
            }
        } while (!allChecked);
        exchange(a, up, right);         // Trennelement an endgültige Position (a[up)
        if (left < (up - 1)) {          // linke Hälfte
            quicksort(a, left, (up - 1));
        }
        if ((up + 1) < right) {         // rechte Hälfte, ohne Pivot
            quicksort(a, (up + 1), right);
        }
    }

    /**
     * Vertauscht zwei bestimmte Zahlen im Array.
     *
     * @param a           int-Array
     * @param firstIndex  Index der ersten Zahl
     * @param secondIndex Index der zweiten Zahl
     */
    private static final void exchange(final int[] a, final int firstIndex, final int secondIndex) {
        int tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    public static void insertionSort(int[] arr, int low, int n) {
        // Start from second element (element at index 0
        // is already sorted)
        for (int i = low + 1; i <= n; i++) {
            int value = arr[i];
            int j = i;

            // Find the index j within the sorted subset arr[0..i-1]
            // where element arr[i] belongs
            while (j > low && arr[j - 1] > value) {
                arr[j] = arr[j - 1];
                j--;
            }
            // Note that subarray arr[j..i-1] is shifted to
            // the right by one position i.e. arr[j+1..i]

            arr[j] = value;
        }
    }
}
