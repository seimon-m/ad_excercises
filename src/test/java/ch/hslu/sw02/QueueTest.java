package ch.hslu.sw02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void testSizeZero() {
        Queue queue = new Queue();
        assertEquals(0, queue.size());
    }

    @Test
    void testAdd1() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('B');
        queue.add('C');
        assertEquals(3, queue.size());
    }

    @Test
    void testAdd2() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('B');
        queue.add('C');
        queue.add('D');
        queue.add('E');
        queue.add('F');
        queue.add('G');
        queue.add('H');
        assertEquals(8, queue.size());
    }

    @Test
    void testAdd3() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('B');
        queue.add('C');
        queue.add('D');
        queue.add('E');
        queue.add('F');
        queue.add('G');
        queue.add('H');
        Assertions.assertThrows(BufferOverflowException.class, () -> {
            queue.add('I');
        });
    }

    @Test
    void testAdd4() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('B');
        queue.add('C');
        queue.add('D');
        queue.add('E');
        queue.add('F');
        queue.add('G');
        queue.add('H');
        queue.poll();
        queue.add('I');
        queue.poll();
        queue.poll();
        queue.add('J');
        assertEquals(7, queue.size());
    }

    @Test
    void testPoll1() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('B');
        queue.add('C');
        assertEquals('A', queue.poll());
    }

    @Test
    void testPoll2() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('B');
        queue.poll();
        assertEquals('B', queue.poll());
    }

    @Test
    void testPoll3() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('B');
        queue.poll();
        assertEquals('B', queue.poll());
    }

    @Test
    void testPoll4() {
        Queue queue = new Queue();
        Assertions.assertThrows(BufferUnderflowException.class, () -> {
            queue.poll();
        });
    }

    @Test
    void testPoll5() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('B');
        queue.poll();
        queue.poll();
        assertEquals(0, queue.size());
    }

    @Test
    void testPoll6() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('B');
        queue.poll();
        queue.poll();
        Assertions.assertThrows(BufferUnderflowException.class, () -> {
            queue.poll();
        });
    }

}