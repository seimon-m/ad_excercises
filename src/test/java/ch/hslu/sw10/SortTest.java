package ch.hslu.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {
    private static final Logger LOG = LogManager.getLogger(SortTest.class);
    private final int[] array = {5, 2, 8, 0, 22, -7, 12, 5, 19};


    @Test
    void insertionSort() {
        int[] actual = array.clone();
        int[] expected = {-7, 0, 2, 5, 5, 8, 12, 19, 22};
        Sort.insertionSort(actual);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void insertionSort2() {
        int[] actual = array.clone();
        int[] expected = {-7, 0, 2, 5, 5, 8, 12, 19, 22};
        Sort.insertionSort2(actual);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void selectionSort() {
        int[] actual = array.clone();
        int[] expected = {-7, 0, 2, 5, 5, 8, 12, 19, 22};
        Sort.selectionSort(actual);
        for (int i = 0; i < actual.length; i++) {
            //LOG.debug(actual[i]);
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void bubbleSort() {
        int[] actual = array.clone();
        int[] expected = {-7, 0, 2, 5, 5, 8, 12, 19, 22};
        Sort.bubbleSort(actual);
        for (int i = 0; i < actual.length; i++) {
            //LOG.debug(actual[i]);
            assertEquals(expected[i], actual[i]);
        }
    }
}