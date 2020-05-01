package ch.hslu.sw10;

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
        for (int i = 0; i < aDummy.length - 1; i++) {
            a[i] = aDummy[i + 1];
        }
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
                    int smallerElement = element;
                    a[j] = a[j - 1];
                    a[j - 1] = smallerElement;
                }
            }
        }
    }
}
