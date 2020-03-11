package ch.hslu.sw04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * Negative values and zero are not allowed.
 * Zero is free, -1 is a tombstone.
 * <p>
 * TODO: search und add funktionieren nur bis array ende. Diese müssten je nachdem auch wieder bei Index 0 anfangen.
 */

public class HashsetCollision implements HashsetInterface {

    private static final Logger LOG = LogManager.getLogger(HashsetCollision.class);
    private int[] storage = new int[10];
    private int size;

    private int generateIndexFromHash(final Integer element) {
        return Math.abs(element.hashCode() % storage.length);
    }

    public boolean isFull() {
        if (this.size == storage.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(Integer element) {
        if (element <= 0) {
            throw new IllegalArgumentException("Number can't be zero or negative");
        }
        if (this.isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (storage[generateIndexFromHash(element)] == 0 || storage[generateIndexFromHash(element)] == -1) {
            storage[generateIndexFromHash(element)] = element;
            size++;
            LOG.debug(toString());
            return true;
        }
        int index = generateIndexFromHash(element);
        for (int i = 0; i < storage.length; i++) {
            if (storage[index] == 0 || storage[index] == -1) {
                storage[index] = element;
                size++;
                LOG.debug(toString());
                return true;
            } else {
                index++;
            }
        }
        return false;
    }

    @Override
    public Integer remove(final Integer element) {
        Integer returnValue = storage[generateIndexFromHash(element)];
        storage[generateIndexFromHash(element)] = -1;
        size--;
        LOG.info(toString());
        return returnValue;
    }

    @Override
    public boolean search(Integer element) {
        return false;
    }

    public int searchInt(Integer element) {
        int index = generateIndexFromHash(element);

        if (element.equals(storage[index])) {
            return index;
        }
        for (int j = index; j < storage.length; j++) {
            if (storage[j] == 0) {
                return -1;
            } else if (element.equals(storage[j])) {
                return j;
            }
        }
        return -2;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "HashsetCollision{" +
                "storage=" + Arrays.toString(storage) +
                ", size=" + size +
                '}';
    }
}


