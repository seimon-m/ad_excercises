package ch.hslu.sw02;

import java.util.EmptyStackException;

public class Stack implements StackInterface {
    private String[] stack;
    private int actualSize = 0;
    private int headIndex = -1;

    public Stack(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be less than zero");
        }
        stack = new String[size];
    }

    @Override
    public String push(String string) {
        if (!isFull()) {
            stack[this.headIndex + 1] = string;
            this.headIndex++;
            this.actualSize++;
            return string;
        } else {
            throw new StackOverflowError();
        }
    }

    @Override
    public String pop() {
        if (!isEmpty()) {
            String value = stack[this.headIndex];
            stack[this.headIndex] = null; // Referenz definitiv entfernen
            this.headIndex--;
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
        return this.actualSize == 0;
    }

    @Override
    public boolean isFull() {
        return this.actualSize == stack.length;
    }
}
