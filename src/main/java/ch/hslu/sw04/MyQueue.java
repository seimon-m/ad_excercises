package ch.hslu.sw04;

import ch.hslu.sw02.QueueInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Arrays;

public class MyQueue {

    private static final Logger LOG = LogManager.getLogger(MyQueue.class);
    private int limit;
    private String[] buffer;
    private int head;
    private int tail;
    private int size;

    public MyQueue(final int size) {
        this.limit = size;
        buffer = new String[limit];
    }

    public void add(String element) {
        if (this.size < this.limit) {
            this.buffer[tail] = element;
            this.size++;
            this.moveTail();
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

    public String poll() {
        if (size != 0) {
            String returnValue = buffer[head];
            buffer[head] = null;
            this.size--;
            this.moveHead();
            return returnValue;
        } else {
            throw new BufferUnderflowException();
        }
    }

    public int size() {
        return this.size;
    }
}
