package ch.hslu.sw02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testIsEmpty() {
        Stack stack = new Stack();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        Stack stack = new Stack();
        stack.push("Test1");
        assertEquals(false, stack.isEmpty());
    }
}