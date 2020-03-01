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
            String returnString = stack[this.lastFilledIndex];
            this.lastFilledIndex--;
            actualSize--;
            return returnString;
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
        int usedIndexes = 0;
//        for (int i = 0; i < stack.length; i++) {
//            if (stack[i] != null) {
//                usedIndexes++;
//            }
//        }
//        if (usedIndexes == stack.length) {
//            return true;
//        } else {
//            return false;
//        }
        if (this.actualSize == stack.length) {
            return true;
        } else {
            return false;
        }
    }
}
