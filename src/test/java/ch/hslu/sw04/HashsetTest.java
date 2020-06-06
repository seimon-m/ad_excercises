package ch.hslu.sw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashsetTest {

    @Test
    void add() {
        Hashset hashset = new Hashset();
        hashset.add(26);
        assertTrue(hashset.search(26));
    }

    @Test
    void add2() {
        Hashset hashset = new Hashset();
        hashset.add(2147483647);
        assertTrue(hashset.search(2147483647));
    }

    @Test
    void add3() {
        Hashset hashset = new Hashset();
        hashset.add(-2147483648);
        assertTrue(hashset.search(-2147483648));
    }

    @Test
    void add4() {
        Hashset hashset = new Hashset();
        hashset.add(0);
        assertTrue(hashset.search(0));
    }

    @Test
    void add5() {
        Hashset hashset = new Hashset();
        hashset.add(1);
        hashset.add(2);
        hashset.add(3);
        hashset.add(4);
        hashset.add(5);
        hashset.add(6);
        hashset.add(7);
        hashset.add(8);
        hashset.add(9);
        assertEquals(9, hashset.getSize());
    }

    @Test
    void add6() {
        Hashset hashset = new Hashset();
        hashset.add(10);
        hashset.add(20);
        hashset.add(30);
        hashset.add(40);
        hashset.add(50);
        assertEquals(1, hashset.getSize());
    }

    @Test
    void add7() {
        Hashset hashset = new Hashset();
        hashset.add(5);
        assertFalse(hashset.add(5));
    }

    @Test
    void remove1() {
        Hashset hashset = new Hashset();
        hashset.add(5);
        assertEquals(5, hashset.remove(5));
    }

    @Test
    void remove2() {
        Hashset hashset = new Hashset();
        hashset.add(5);
        hashset.remove(5);
        assertEquals(0, hashset.getSize());
    }
}