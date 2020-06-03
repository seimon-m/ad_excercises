package ch.hslu.sw14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuicksearchTest {

    @Test
    void quickSearch() {
        String a = "abcdefghjiabaabaaabac";
        String p = "abac";
        assertEquals(17, Quicksearch.quickSearch(a, p));
    }
    @Test
    void quickSearch1() {
        String a = "abcdefghjiabaabaaabaac";
        String p = "abac";
        assertEquals(-1, Quicksearch.quickSearch(a, p));
    }
    @Test
    void quickSearch2() {
        String a = "acdefghijklmnopqrst";
        String p = "bbbb";
        assertEquals(-1, Quicksearch.quickSearch(a, p));
    }
    @Test
    void quickSearch3() {
        String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String p = "aaaaaaaaaaaaaaaaaaba";
        assertEquals(-1, Quicksearch.quickSearch(a, p));
    }
    @Test
    void quickSearch4() {
        String a = "aaaabacabacabacabacabacabac";
        String p = "abac";
        assertEquals(3, Quicksearch.quickSearch(a, p));
    }
}