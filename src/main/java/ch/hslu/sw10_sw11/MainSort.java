package ch.hslu.sw10_sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class MainSort {
    private static final Logger LOG = LogManager.getLogger(MainSort.class);
    private static final int[] smallArray = randomInts(50_000);
    private static final int[] mediumArray = randomInts(100_000);
    private static final int[] bigArray = randomInts(1_000_000);
    private static final char[] charArray = randomChars(500_000);

    public static void main(String[] args) {
        MainSort.measureMediumInsertion1(5);
        MainSort.measureBigInsertion1(5);
        MainSort.measureMediumInsertion2(5);
        MainSort.measureBigInsertion2(5);
//        MainSort.measureMediumSelection(5);
//        MainSort.measureBigSelection(5);
//        MainSort.measureMediumBubble(5);
//        MainSort.measureBigBubble(5);
//        MainSort.measureQuicksortChar(5);
//        MainSort.measureQuicksortInt(5);
    }

    private static void measureMediumInsertion1(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = smallArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.insertionSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Medium Insertion 1 | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureBigInsertion1(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = mediumArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.insertionSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Big Insertion 1 | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureMediumInsertion2(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = smallArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.insertionSort2(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Medium Insertion 2 | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureBigInsertion2(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = mediumArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.insertionSort2(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Big Insertion 2 | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureMediumSelection(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = smallArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.selectionSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Medium Selection | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureBigSelection(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = mediumArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.selectionSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Big Selection | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureMediumBubble(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = smallArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.bubbleSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Medium Bubble | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureBigBubble(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = mediumArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.bubbleSort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Big Bubble | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureQuicksortChar(final int n) {
        for (int i = 1; i <= n; i++) {
            char[] array = charArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.quicksort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Quicksort char | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static void measureQuicksortInt(final int n) {
        for (int i = 1; i <= n; i++) {
            int[] array = bigArray.clone();
            long time1 = System.currentTimeMillis();
            Sort.quicksort(array);
            long time2 = System.currentTimeMillis();
            LOG.info("Quicksort int | Time " + i + ": " + (time2 - time1) + "ms");
        }
    }

    private static int[] randomInts(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return array;
    }

    private static char[] randomChars(final int length) {
        char[] array = new char[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = (char) (random.nextInt(52) + 'A');
        }
        return array;
    }
}


