package ch.hslu.sw13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordproblemTest {

    @Test
    void isWordLanguage1() {
        assertEquals(true, Wordproblem.isWordLanguage("0"));
    }

    @Test
    void isWordLanguage2() {
        assertEquals(true, Wordproblem.isWordLanguage("010"));
    }

    @Test
    void isWordLanguage3() {
        assertEquals(true, Wordproblem.isWordLanguage("01110"));
    }

    @Test
    void isWordLanguage4() {
        assertEquals(true, Wordproblem.isWordLanguage("0111010"));
    }

    @Test
    void isWordLanguage5() {
        assertEquals(false, Wordproblem.isWordLanguage("1"));
    }

    @Test
    void isWordLanguage6() {
        assertEquals(false, Wordproblem.isWordLanguage("0110"));
    }

    @Test
    void isWordLanguage7() {
        assertEquals(false, Wordproblem.isWordLanguage("111010"));
    }
}