package ch.hslu.sw02;

import java.util.EmptyStackException;

public class Stack implements StackInterface {
    private String[] stack;
    private int actualSize = 0;
    private int lastFilledIndex = -1;

    public Stack(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be less than zero");
        }
        stack = new String[size];
    }

    @Override
    public String push(String string) {
        if (!isFull()) {
            stack[this.lastFilledIndex + 1] = string;
            this.lastFilledIndex++;
            actualSize++;
            return string;
        } else {
            throw new StackOverflowError();
        }
    }

    @Override
    public String pop() {
        if (!isEmpty()) {
            String value = stack[this.lastFilledIndex];
            stack[this.lastFilledIndex] = null; // Referenz definitiv entfernen
            this.lastFilledIndex--;
            actualSize--;
            return value;
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public int size() {
        return this.actualSize;
    }

    @Override
    public boolean isEmpty() {
        if (this.actualSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if (this.actualSize == stack.length) {
            return true;
        } else {
            return false;
        }
    }
}
