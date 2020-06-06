package ch.hslu.sw04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/*
 * Negative values and zero are not allowed.
 * Zero is free, -1 is a tombstone.
 */

public class HashsetCollision implements HashsetInterface {

    private static final Logger LOG = LogManager.getLogger(HashsetCollision.class);
    private int[] storage = new int[10];
    private int size;
    private final byte TOMBSTONE = -1;

    private int generateIndexFromHash(final Integer element) {
        return Math.abs(element.hashCode() % storage.length);
    }

    public boolean isFull() {
        return this.size == storage.length;
    }

    @Override
    public boolean add(Integer element) {
        if (element <= 0) {
            throw new IllegalArgumentException("Number can't be zero or negative");
        }
        if (this.isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int index = generateIndexFromHash(element);

        if (storage[index] == 0 || storage[index] == TOMBSTONE) {
            storage[index] = element;
            size++;
            LOG.debug(toString());
            return true;
        }

        while (storage[index] != 0 && storage[index] != TOMBSTONE) {
            if (index < storage.length - 1) {
                index++;
            } else {
                index = 0;
            }
        }
        storage[index] = element;
        size++;
        LOG.debug(toString());
        return true;
    }

    @Override
    public Integer remove(final Integer element) {
        Integer returnValue = storage[generateIndexFromHash(element)];
        storage[generateIndexFromHash(element)] = TOMBSTONE;
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
        int originalIndex = index;
        if (element.equals(storage[index])) {
            return index;
        }
        index++;
        while (storage[index] != 0) {
            if (index == originalIndex) {
                return -2; // Not found
            } else if (element.equals(storage[index])) {
                return index;// Found
            } else if (index < storage.length - 1) {
                index++;
            } else {
                index = 0;
            }
        }
        return index;
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


