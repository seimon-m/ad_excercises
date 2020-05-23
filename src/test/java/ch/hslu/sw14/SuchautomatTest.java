package ch.hslu.sw14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuchautomatTest {

    @Test
    void stateSearch() {
        String a = "ANANAS";
        assertEquals(0, Suchautomat.stateSearch(a));
    }

    @Test
    void stateSearch1() {
        String a = "abcdANANAS";
        assertEquals(4, Suchautomat.stateSearch(a));
    }

    @Test
    void stateSearch2() {
        String a = "abcdefghj";
        assertEquals(-1, Suchautomat.stateSearch(a));
    }

    @Test
    void stateSearch3() {
        String a = "ANANAANANAANANANANANANAS";
        assertEquals(18, Suchautomat.stateSearch(a));
    }
}