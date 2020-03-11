package ch.hslu.sw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashsetCollisionTest {

    @Test
    void add1() {
        HashsetCollision hashset = new HashsetCollision();
        hashset.add(1);
        hashset.add(11);
        assertEquals(2, hashset.getSize());
    }

    @Test
    void search1() {
        HashsetCollision hashset = new HashsetCollision();
        hashset.add(1);
        hashset.add(11);
        assertEquals(1, hashset.searchInt(1));
    }

    @Test
    void search2() {
        HashsetCollision hashset = new HashsetCollision();
        hashset.add(1);
        hashset.add(11);
        assertEquals(2, hashset.searchInt(11));
    }

    @Test
    void search3() {
        HashsetCollision hashset = new HashsetCollision();
        hashset.add(1);
        hashset.add(2);
        hashset.add(11);
        assertEquals(3, hashset.searchInt(11));
    }

    @Test
    void remove1() {
        HashsetCollision hashset = new HashsetCollision();
        hashset.add(1);
        hashset.add(2);
        hashset.add(11);
        hashset.remove(2);
        assertEquals(3, hashset.searchInt(11));
    }

    @Test
    void remove2() {
        HashsetCollision hashset = new HashsetCollision();
        hashset.add(1);
        hashset.add(2);
        hashset.add(11);
        hashset.remove(2);
        hashset.add(22);
        assertEquals(2, hashset.searchInt(22));
    }
}