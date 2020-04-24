package ch.hslu.sw10;

public class Sort {
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
}
