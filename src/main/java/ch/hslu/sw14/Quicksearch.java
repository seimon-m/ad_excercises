package ch.hslu.sw14;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Quicksearch {

    private static final Logger LOG = LogManager.getLogger(Quicksearch.class);

    public static void main(String[] args) throws Exception {
        String a = readFileAsString("/Users/simon/DasBuchDerBilder.txt");
        long time1 = System.currentTimeMillis();
        int result = Quicksearch.quickSearch(a, "Ouvertüre");
        long time2 = System.currentTimeMillis();
        LOG.info("Pattern at index: " + result + " | Time: " + (time2 - time1) + "ms");
    }

    public static String readFileAsString(String Book)throws Exception{
        String a = "";
        a = new String(Files.readAllBytes(Paths.get(Book)));
        return a;
    }

    /**
     * Durchsucht eine Zeichenkette mittels quickSearch.
     *
     * @param a Zeichenkette, die durchsucht wird.
     * @return Index der Fundstelle oder -1, falls Pattern in a nicht gefunden wurde.
     */
    public static int quickSearch(final String a, final String p) {
        final int n = a.length();   // Length of text
        final int m = p.length();   // Length of pattern
        final int range = 256;      // -> ASCII-Range
        final int[] shift = new int[range];

        // init shift-array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }

        // overwrite fields according pattern
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }

        // search
        int i = 0;          // index to string
        int j = 0;          // index to pattern p
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // match
                j++;
            } else { // mismatch
                if ((i + m) < n) { // a.charAt(i1+m) is not outside a
                    i += shift[a.charAt(i + m)]; // jump forward
                    j = 0;
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        }
        while ((j < m) && ((i + m) <= n));
        // (pattern p not found) && (end of a not reached)
        if (j == m) {
            return i; // pattern found
        } else {
            return -1;// pattern not found
        }
    }

    public static int optimalMismatch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 256; // -> ASCII-Range
        final int[] shift = new int[range];
        final char[] pArray= p.toCharArray();

        // init shift-array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }

        // overwrite fields according pattern
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }

        // search
        int i = 0;      // index to string
        int j = 0;      // index to pattern p
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // match
                j++;
            } else { // mismatch
                if ((i + m) < n) { // a.charAt(i1+m) is not outside a
                    i += shift[a.charAt(i + m)]; // jump forward
                    swapElement(pArray, j);
                    j = 0;
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        }
        while ((j < m) && ((i + m) <= n));
        // (pattern p not found) && (end of a not reached)
        if (j == m) {
            return i; // pattern found
        } else {
            return -1;// pattern not found
        }
    }

    private static void swapElement(char[] array, int element) {
        char temp = array[element];
        array[element] = array[0];
        array[0] = temp;
    }
}



