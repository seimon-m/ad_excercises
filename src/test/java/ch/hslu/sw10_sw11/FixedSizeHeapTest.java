package ch.hslu.sw10_sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

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
    void insert3() {
        FixedSizeHeap heap = new FixedSizeHeap(5);
        heap.insert(20);
        heap.getMax();
        assertEquals(20, heap.getMax());
    }
}