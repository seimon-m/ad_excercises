package ch.hslu.sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Aha {

    private static final Logger LOG = LogManager.getLogger(Aha.class);
    private static int i1 = 0;
    private static int i2 = 0;
    private static int i3 = 0;

    public static void main(String[] args) {
        task(2);
    }


    public static void task(final int n) {
        task1();
        task1();
        task1();
        task1();    // T ~ 4

        for (int i = 0; i < n; i++) {   // äussere Schleife: n-mal

            task2();
            task2();
            task2();    // T ~ n · 3

            for (int j = 0; j < n; j++) {   // innere Schleife: n-mal

                task3();    // T ~ n · n· 2
                task3();
            }

        }

        LOG.info("Task 1: " + i1 + " | Task 2: " + i2 + " | Task 3: " + i3);

    }

    public static void task1() {
        i1++;
        sleep(5);
    }

    public static void task2() {
        i2++;
        sleep(5);
    }

    public static void task3() {
        i3++;
        sleep(5);
    }

    public static void sleep(final int millis) {
        try{
            Thread.sleep(millis);
        } catch (Exception e) {
            LOG.error(e);
        }
    }
}
