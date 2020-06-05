package ch.hslu.sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fibonacci {

    private static final Logger LOG = LogManager.getLogger(Fibonacci.class);

    static long storage[];

    public static void main(final String[] args) {
        int n = 50;

        long time1 = System.currentTimeMillis();
        LOG.info(fiboIter(n));
        long time2 = System.currentTimeMillis();
        LOG.info("Fibonacci Iterativ: " + (time2 - time1) + "ms");

        time1 = System.currentTimeMillis();
        LOG.info(fiboRec1(n));
        time2 = System.currentTimeMillis();
        LOG.info("Fibonacci Rekursiv: " + (time2 - time1) + "ms");

        time1 = System.currentTimeMillis();
        LOG.info(fiboRec2(n));
        time2 = System.currentTimeMillis();
        LOG.info("Fibonacci Rekursiv mit Speicher: " + (time2 - time1) + "ms");
    }

    public static long fiboIter(int n) {
        if (n > 0) {
            long aktuelle = 1, temp = 1, vorherige = 0;
            for (long i = 1; i < n; i++) {
                temp = aktuelle;
                aktuelle = aktuelle + vorherige;
                vorherige = temp;
            }
            return aktuelle;
        } else {
            return 0;
        }
    }

    private static long fiboRec1(int n) {
        if (n == 1 || n == 2) { // Rekursionbasis
            return 1;
        }
        return fiboRec1(n - 1) + fiboRec1(n - 2); // Rekursionvorschrift
    }

    public static long fiboRec2(final int n) {
        storage = new long[n + n];
        return fiboHelper(n);
    }

    private static long fiboHelper(int n) {
        if (storage[n] != 0) {
            return storage[n];
        } else if (n < 2) {
            storage[n] = n;
            return storage[n];
        } else {
            storage[n] = fiboHelper(n - 1) + fiboHelper(n - 2);
        }
        return storage[n];
    }
}




