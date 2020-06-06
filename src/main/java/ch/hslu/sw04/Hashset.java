package ch.hslu.sw04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

// Integer: Returns a hash code value for this object, equal to the primitive int value represented by this Integer object.

public class Hashset implements HashsetInterface {

    private static final Logger LOG = LogManager.getLogger(Hashset.class);
    private int[] storage = new int[10];
    private int size;

    private int generateIndexFromHash(final Integer element) {
        return Math.abs(element.hashCode() % storage.length);
    }

    @Override
    public boolean add(Integer element) {
        if (storage[generateIndexFromHash(element)] == 0) {
            storage[generateIndexFromHash(element)] = element;
            size++;
            LOG.debug(toString());
            return true;
        }
        return false;
    }

    @Override
    public Integer remove(final Integer element) {
        Integer returnValue = storage[generateIndexFromHash(element)];
        storage[generateIndexFromHash(element)] = 0;
        size--;
        LOG.debug(toString());
        return returnValue;
    }

    @Override
    public boolean search(Integer element) {
        for (int value : storage) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "Hashset{" +
                "storage=" + Arrays.toString(storage) +
                '}';
    }
}


