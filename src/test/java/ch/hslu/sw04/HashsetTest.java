package ch.hslu.sw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashsetTest {

    @Test
    void add() {
        Hashset hashset = new Hashset();
        hashset.add(26);
        assertEquals(true, hashset.search(26));
    }

    @Test
    void add2() {
        Hashset hashset = new Hashset();
        hashset.add(2147483647);
        assertEquals(true, hashset.search(2147483647));
    }

    @Test
    void add3() {
        Hashset hashset = new Hashset();
        hashset.add(-2147483648);
        assertEquals(true, hashset.search(-2147483648));
    }

    @Test
    void add4() {
        Hashset hashset = new Hashset();
        hashset.add(0);
        assertEquals(true, hashset.search(0));
    }

    @Test
    void add5() {
        Hashset hashset = new Hashset();
        hashset.add(1);
        hashset.add(435);
        hashset.add(345);
        hashset.add(45223);
        hashset.add(3455);
        hashset.add(34);
        hashset.add(55433);
        hashset.add(345);
        hashset.add(333);
        hashset.add(28933);
        assertEquals(10, hashset.getSize());
    }

    @Test
    void add6() {
        Hashset hashset = new Hashset();
        hashset.add(1);
        hashset.add(435);
        hashset.add(345);
        hashset.add(45223);
        hashset.add(3455);
        hashset.add(34);
        hashset.add(55433);
        hashset.add(345);
        hashset.add(333);
        hashset.add(28933);
        hashset.add(28936);
        assertEquals(11, hashset.getSize());
    }

    @Test
    void add7() {
        Hashset hashset = new Hashset();
        hashset.add(5);
        assertEquals(false, hashset.add(5));
    }

    @Test
    void remove1() {
        Hashset hashset = new Hashset();
        hashset.add(5);
        assertEquals(true, hashset.remove(5));
    }

    @Test
    void remove2() {
        Hashset hashset = new Hashset();
        hashset.add(5);
        hashset.remove(5);
        assertEquals(0, hashset.getSize());
    }
}