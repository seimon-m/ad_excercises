package ch.hslu.sw02;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Queue implements QueueInterface {

    private static final Logger LOG = LogManager.getLogger(Queue.class);
    private int limit = 8;
    private char[] buffer = new char[limit];
    private int head;
    private int tail;
    private int size;

    @Override
    public void add(char element) {
        if (this.size < this.limit) {
            this.buffer[tail] = element;
            this.size++;
            this.moveTail();
            LOG.debug(toString());
        } else {
            throw new BufferOverflowException();
        }
    }

    private void moveTail() {
        if (tail < buffer.length - 1) {
            this.tail++;
        } else if (tail == buffer.length - 1) {
            this.tail = 0;
        }
    }

    private void moveHead() {
        if (head < buffer.length - 1) {
            this.head++;
        } else if (head == buffer.length - 1) {
            this.head = 0;
        }
    }

    @Override
    public char poll() {
        if (size != 0) {
            char returnValue = buffer[head];
            buffer[head] = 0;
            this.size--;
            this.moveHead();
            LOG.debug(toString());
            return returnValue;
        } else {
            throw new BufferUnderflowException();
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "limit=" + limit +
                ", buffer=" + Arrays.toString(buffer) +
                ", head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
