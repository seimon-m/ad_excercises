package ch.hslu.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class MainSort {
    private static final Logger LOG = LogManager.getLogger(MainSort.class);
    private static final int[] mediumArray = generateRandomArray(50_000);
    private static final int[] bigArray = generateRandomArray(100_000);

    public static void main(String[] args) {
        MainSort.measureMediumInsertion(5);
        MainSort.measureBigInsertion(5);
        MainSort.measureMediumSelection(5);
        MainSort.measureBigSelection(5);
        MainSort.measureMediumBubble(5);
        MainSort.measureBigBubble(5);
    }

    private static void measureMediumInsertion(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = mediumArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.insertionSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Medium Insertion | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureBigInsertion(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = bigArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.insertionSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Big Insertion | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureMediumSelection(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = mediumArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.selectionSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Medium Selection | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureBigSelection(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = bigArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.selectionSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Big Selection | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureMediumBubble(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = mediumArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.bubbleSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Medium Bubble | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureBigBubble(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = bigArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.bubbleSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Big Bubble | Time " + i + ": " + (time2 - time1) + "ms");
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


