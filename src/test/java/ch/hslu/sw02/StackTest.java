package ch.hslu.sw02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testIsEmpty() {
        Stack stack = new Stack(1);
        assertEquals(true, stack.isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        Stack stack = new Stack(1);
        stack.push("Test1");
        assertEquals(false, stack.isEmpty());
    }

    @Test
    void testIsFull() {
        Stack stack = new Stack(1);
        stack.push("Test1");
        assertEquals(true, stack.isFull());
    }

    @Test
    void testPush() {
        Stack stack = new Stack(5);
        stack.push("Test1");
        stack.push("Test2");
        stack.push("Test3");
        assertEquals(3, stack.size());
    }

    @Test
    void testPushFull() {
        Stack stack = new Stack(3);
        stack.push("Test1");
        stack.push("Test2");
        stack.push("Test3");
        Assertions.assertThrows(StackOverflowError.class, () -> {
            stack.push("Test4");
        });

    }

    @Test
    void testPop1() {
        Stack stack = new Stack(5);
        stack.push("Test1");
        stack.push("Test2");
        stack.push("Test3");
        stack.pop();
        assertEquals(2, stack.size());
    }

    @Test
    void testPop2() {
        Stack stack = new Stack(5);
        stack.push("Test1");
        stack.push("Test2");
        assertEquals("Test2", stack.pop());
    }

    @Test
    void testPopEmpty() {
        Stack stack = new Stack(5);
        Assertions.assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void testSize() {
        Stack stack = new Stack(5);
        stack.push("Test1");
        stack.push("Test2");
        stack.pop();
        stack.push("Test3");
        stack.pop();
        stack.push("Test4");
        assertEquals(2, stack.size());
    }
}