package ch.hslu.sw10;


import ch.hslu.sw07.end.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class MainSort {
    private static final Logger LOG = LogManager.getLogger(MainSort.class);
    private static final int[] mediumArray = generateRandomArray(100000);
    private static final int[] bigArray = generateRandomArray(400000);

    public static void main(String[] args) {
        MainSort.measureMediumArray(5);
        MainSort.measureBigArray(5);
    }

    private static void measureMediumArray(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = mediumArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.insertionSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Medium Array | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureBigArray(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = bigArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.insertionSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Big Array | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static int[] generateRandomArray(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return array;
    }
}


