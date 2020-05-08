package ch.hslu.sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fibonacci {

    private static final Logger LOG = LogManager.getLogger(Fibonacci.class);

    public static void main(final String[] args) {
        for (int i = 1; i <= 7; i++) {
            LOG.info(fiboRec1(i));
        }
        fiboIter(7);
        LOG.info(fiboRec2(10));
    }

    public static void fiboIter(int n) {
        int z0 = 0;
        int z1 = 1;
        int sum = 0;

        for (int i = 0; i <= n; i++) {
            LOG.info(z0);
            sum = z0 + z1;
            z0 = z1;
            z1 = sum;
        }
    }


    private static int fiboRec1(int n) {
        if (n == 1 || n == 2) { // Rekursionbasis
            return 1;
        }
        return fiboRec1(n - 1) + fiboRec1(n - 2); // Rekursionvorschrift
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static int fiboRec2(final int n) {
        return n > 1 ? fiboRec2(n - 1) + fiboRec2(n - 2) : n;
    }
}




