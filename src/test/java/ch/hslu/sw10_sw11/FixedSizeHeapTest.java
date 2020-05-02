package ch.hslu.sw10_sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.BufferOverflowException;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeHeapTest {

    private static final Logger LOG = LogManager.getLogger(FixedSizeHeapTest.class);

//    @Test
//    void insert1() {
//        FixedSizeHeap heap = new FixedSizeHeap(5);
//        heap.insert(10);
//        heap.insert(5);
//        heap.insert(2);
//        heap.insert(6);
//        heap.insert(20);
//    }

//    @Test
//    void insert2() {
//        FixedSizeHeap heap = new FixedSizeHeap(10);
//        heap.insert(1);
//        heap.insert(2);
//        heap.insert(3);
//        heap.insert(4);
//        heap.insert(5);
//        heap.insert(6);
//        heap.insert(7);
//        heap.insert(8);
//    }

//    @Test
//    void insert3() {
//        FixedSizeHeap heap = new FixedSizeHeap(6);
//        heap.insert(20);
//        heap.insert(10);
//        heap.insert(5);
//        heap.insert(12);
//        heap.insert(7);
//        heap.insert(50);
//    }

    @Test
    void getMax1() {
        FixedSizeHeap heap = new FixedSizeHeap(5);
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        assertEquals(20, heap.getMax());
    }

    @Test
    void getMax2() {
        FixedSizeHeap heap = new FixedSizeHeap(5);
        heap.insert(20);
        heap.insert(10);
        heap.insert(30);
        assertEquals(30, heap.getMax());
    }

    @Test
    void getMax3() {
        FixedSizeHeap heap = new FixedSizeHeap(5);
        heap.insert(20);
        heap.insert(10);
        heap.insert(30);
        heap.getMax();
        assertEquals(20, heap.getMax());
    }

    @Test
    void getMax4() {
        FixedSizeHeap heap = new FixedSizeHeap(6);
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(7);
        heap.insert(50);
        heap.getMax();
        heap.getMax();
        assertEquals(12, heap.getMax());
    }

    @Test
    void isEmpty() {
        FixedSizeHeap heap = new FixedSizeHeap(5);
        heap.insert(20);
        heap.getMax();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            heap.getMax();
        });
    }

    @Test
    void isFull() {
        FixedSizeHeap heap = new FixedSizeHeap(2);
        heap.insert(20);
        heap.insert(10);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            heap.insert(30);
        });
    }
}