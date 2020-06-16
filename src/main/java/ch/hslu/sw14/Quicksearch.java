package ch.hslu.sw14;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Quicksearch {

    private static final Logger LOG = LogManager.getLogger(Quicksearch.class);
    private static List<Long> time = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int rounds = 10;
        for (int i = 0; i < rounds; i++) {
            String a = readFileAsString("/Users/simon/Documents/GitHub/ad_excercises/src/main/java/ch/hslu/sw14/DasBuchDerBilder.txt");
            long time1 = System.currentTimeMillis();
            long result = Quicksearch.quickSearch(a, "HalloVelo");
            long time2 = System.currentTimeMillis();
            time.add(time2 - time1);
            LOG.info("Pattern at index: " + result + " | Time: " + (time2 - time1) + "ms");
        }
        long sum = 0;
        for (Long t : time) {
            sum += t;
        }
        LOG.info("Quicksort average time: " + sum / time.size() + "ms");

        time.clear();
        for (int i = 0; i < rounds; i++) {
            String a = readFileAsString("/Users/simon/Documents/GitHub/ad_excercises/src/main/java/ch/hslu/sw14/DasBuchDerBilder.txt");
            long time1 = System.currentTimeMillis();
            long result = Quicksearch.optimalMismatch(a, "HalloVelo");
            long time2 = System.currentTimeMillis();
            time.add(time2 - time1);
            LOG.info("Pattern at index: " + result + " | Time: " + (time2 - time1) + "ms");
        }
        sum = 0;
        for (Long t : time) {
            sum += t;
        }
        LOG.info("OptimalMismatch average time: " + sum / time.size() + "ms");
    }

    public static String readFileAsString(String Book)throws Exception{
        String a;
        a = new String(Files.readAllBytes(Paths.get(Book)));
        return a;
    }

    /**
     * Durchsucht eine Zeichenkette mittels quickSearch.
     *
     * @param a Zeichenkette, die durchsucht wird.
     * @return Index der Fundstelle oder -1, falls Pattern in a nicht gefunden wurde.
     */
    public static long quickSearch(final String a, final String p) {
        final int n = a.length();   // Length of text
        final int m = p.length();   // Length of pattern
        final int range = 56536;      // -> Unicode-Range
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

    public static long optimalMismatch(final String a, final String p) {
        final int n = a.length();   // Length of text
        final int m = p.length();   // Length of pattern
        final int range = 56536;      // -> Unicode-Range
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
                    int elementIndex = a.charAt(i + m); // jump forward
                    i += shift[a.charAt(i + m)];
                    j = 0;
                    reorganiseShift(shift, elementIndex);
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        }
        while ((j < m) && ((i + m) <= n));  // (pattern p not found) && (end of a not reached)
        if (j == m) {
            return i; // pattern found
        } else {
            return -1;// pattern not found
        }
    }


    private static void reorganiseShift(int[] shift, int index) { // Mismatch-Element an erste Stelle im shift-Array
        int old = shift[0];
        shift[0] = shift[index];
        for (int i = 1; i < index; i++) {
            shift[i] = old;
            old = shift[i + 1];
        }
    }
}



