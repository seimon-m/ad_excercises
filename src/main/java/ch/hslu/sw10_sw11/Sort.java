package ch.hslu.sw10_sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Sort {
    private static final Logger LOG = LogManager.getLogger(Sort.class);

    public static void insertionSort(final int[] a) {
        int element;
        int j;
        for (int i = 1; i < a.length; i++) {
            element = a[i]; // Nächstes Element zum einfügen
            j = i; // j dem momentanen Fortschritt übergeben
            while ((j > 0) && (a[j - 1] > element)) { // Wenn linkes Element grösser ist als Element, dann:
                a[j] = a[j - 1]; // Linkes Element mit aktuellem Element tauschen
                j--; // Weiter nach links
            }
            a[j] = element; // Element an der richtigen Stelle einfügen
        }
    }

    public static void insertionSort2(final int[] a) {
        int element;
        int j;
        int[] aDummy = Arrays.copyOf(a, a.length + 1);
        aDummy[aDummy.length - 1] = a[0];
        for (int i = 2; i < aDummy.length; i++) {
            element = aDummy[i]; // Nächstes Element zum einfügen
            aDummy[0] = element;
            j = i; // j dem momentanen Fortschritt übergeben
            while (aDummy[j - 1] > element) { // Wenn linkes Element grösser ist als Element, dann:
                aDummy[j] = aDummy[j - 1]; // Linkes Element mit aktuellem Element tauschen
                j--; // Weiter nach links
            }
            aDummy[j] = element; // Element an der richtigen Stelle einfügen
        }
        System.arraycopy(aDummy, 1, a, 0, aDummy.length - 1);
    }


    public static void selectionSort(final int[] a) {
        int minElement;
        int minIndex;
        int actualElement;
        int j;
        for (int i = 0; i < a.length; i++) {
            actualElement = a[i];
            minElement = a[i];
            minIndex = i;
            j = i;
            while (j < a.length) {
                if (a[j] < minElement) {
                    minElement = a[j];
                    minIndex = j;
                }
                j++;
            }
            if (actualElement != minElement) {
                a[i] = minElement;
                a[minIndex] = actualElement;
            }
        }

    }

    public static void bubbleSort(final int[] a) {
        int element;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < (a.length - i); j++) {
                element = a[j];
                if (a[j - 1] > element) {
                    a[j] = a[j - 1];
                    a[j - 1] = element;
                }
            }
        }
    }

    public static void quicksort(final char[] a) {
        quicksort(a, 0, a.length - 1);
    }

    public static void quicksort(final char[] a, final int left, final int right) {
        int up = left;                 // linke Grenze
        int down = right - 1;           // rechte Grenze (ohne Pivot)
        char t = a[right];              // rechtes Element als Pivot
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

    public static void quicksort(final int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    public static void quicksort(final int[] a, final int left, final int right) {
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
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a           Zeichen-Array
     * @param firstIndex  Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static void exchange(final char[] a, final int firstIndex, final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    /**
     * Vertauscht zwei bestimmte Zahlen im Array.
     *
     * @param a           int-Array
     * @param firstIndex  Index der ersten Zahl
     * @param secondIndex Index der zweiten Zahl
     */
    private static void exchange(final int[] a, final int firstIndex, final int secondIndex) {
        int tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }
}
