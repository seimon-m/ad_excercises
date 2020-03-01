package ch.hslu.sw02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {


    @Test
    void testSize0() {
        List list = new List();
        assertEquals(0, list.size());
    }

    @Test
    void testAddHead() {
        Allocation alloc = new Allocation(0, 5);
        List list = new List();
        list.push(alloc);
        assertEquals(1, list.size());
    }

    @Test
    void testAddHead2() {
        Allocation alloc1 = new Allocation(0, 5);
        Allocation alloc2 = new Allocation(2, 8);
        Allocation alloc3 = new Allocation(3, 7);
        Allocation alloc4 = new Allocation(1, 3);
        List list = new List();
        list.push(alloc1);
        list.push(alloc2);
        list.push(alloc3);
        list.push(alloc4);
        assertEquals(4, list.size());
    }

   @Test
   void testContainsTrue() {
       Allocation alloc1 = new Allocation(2, 5);
       Allocation alloc2 = new Allocation(2, 7);
       Allocation alloc3 = new Allocation(3, 7);
       List list = new List();
       list.push(alloc1);
       list.push(alloc2);
       list.push(alloc3);
       assertEquals(true, list.contains(alloc2));
   }

    @Test
    void testContainsFalse() {
        Allocation alloc1 = new Allocation(0, 5);
        Allocation alloc2 = new Allocation(2, 9);
        List list = new List();
        list.push(alloc1);
        assertEquals(false, list.contains(alloc2));
    }

    @Test
    void testPop1() {
        Allocation alloc1 = new Allocation(0, 5);
        Allocation alloc2 = new Allocation(2, 9);
        List list = new List();
        list.push(alloc1);
        list.push(alloc2);
        assertEquals(alloc2, list.pop());
    }

    @Test
    void testPop2() {
        Allocation alloc1 = new Allocation(0, 5);
        Allocation alloc2 = new Allocation(2, 9);
        List list = new List();
        list.push(alloc1);
        list.push(alloc2);
        list.pop();
        assertEquals(1, list.size());
    }

    @Test
    void testRemove1() {
        Allocation alloc1 = new Allocation(0, 5);
        Allocation alloc2 = new Allocation(2, 9);
        List list = new List();
        list.push(alloc1);
        list.push(alloc2);
        list.remove(alloc2);
        assertEquals(1, list.size());
    }

    @Test
    void testRemove2() {
        Allocation alloc1 = new Allocation(0, 5);
        Allocation alloc2 = new Allocation(2, 9);
        Allocation alloc3 = new Allocation(3, 7);
        List list = new List();
        list.push(alloc1);
        list.push(alloc2);
        list.push(alloc3);
        list.remove(alloc1);
        assertEquals(2, list.size());
    }
}