package ch.hslu.sw10_sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {
    private static final Logger LOG = LogManager.getLogger(SortTest.class);
    private final int[] array = {5, 2, 8, 0, 22, -7, 12, 5, 19};
    private final char[] charArray = {'b', 's', 'u', 'a', 'z', 'y', 's'};


    @Test
    void insertionSort() {
        int[] actual = {5, 2, 8, 0, 22, -7, 12, 5, 19};
        int[] expected = {-7, 0, 2, 5, 5, 8, 12, 19, 22};
        Sort.insertionSort(actual);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void insertionSort2() {
        int[] actual = {5, 2, 8, 0, 22, -7, 12, 5, 19};
        int[] expected = {-7, 0, 2, 5, 5, 8, 12, 19, 22};
        Sort.insertionSort2(actual);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void selectionSort() {
        int[] actual = {5, 2, 8, 0, 22, -7, 12, 5, 19};
        int[] expected = {-7, 0, 2, 5, 5, 8, 12, 19, 22};
        Sort.selectionSort(actual);
        for (int i = 0; i < actual.length; i++) {
            //LOG.debug(actual[i]);
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void bubbleSort() {
        int[] actual = {5, 2, 8, 0, 22, -7, 12, 5, 19};
        int[] expected = {-7, 0, 2, 5, 5, 8, 12, 19, 22};
        Sort.bubbleSort(actual);
        for (int i = 0; i < actual.length; i++) {
            //LOG.debug(actual[i]);
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void quicksortChar1() {
        char[] actual = {'b', 's', 'u', 'a', 'z', 'y', 's'};
        final char[] expected = {'a', 'b', 's', 's', 'u', 'y', 'z'};
        Sort.quicksort(actual, 0, 6);
        for (int i = 0; i < actual.length; i++) {
//            LOG.debug(actual[i]);
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void quicksortChar2() {
        char[] actual = {'b', 's', 'u', 'a', 'z', 'y', 's'};
        final char[] expected = {'a', 'b', 's', 's', 'u', 'y', 'z'};
        Sort.quicksort(actual);
        for (int i = 0; i < actual.length; i++) {
//            LOG.debug(actual[i]);
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void quicksortInt1() {
        int[] actual = {5, 2, 8, 0, 22, -7, 12, 5, 19};
        final int[] expected = {-7, 0, 2, 5, 5, 8, 12, 19, 22};
        Sort.quicksort(actual, 0, 8);
        for (int i = 0; i < actual.length; i++) {
//            LOG.debug(actual[i]);
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void quicksortInt2() {
        int[] actual = {5, 2, 8, 0, 22, -7, 12, 5, 19};
        final int[] expected = {-7, 0, 2, 5, 5, 8, 12, 19, 22};
        Sort.quicksort(actual);
        for (int i = 0; i < actual.length; i++) {
//            LOG.debug(actual[i]);
            assertEquals(expected[i], actual[i]);
        }
    }
}