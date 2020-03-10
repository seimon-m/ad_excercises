package ch.hslu.sw04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

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
    public boolean remove(final Integer element) {
        storage[generateIndexFromHash(element)] = 0;
        size--;
        LOG.debug(toString());
        return true;
    }

    @Override
    public boolean search(Integer element) {
        for (int i = 0; i < storage.length; i++) {
            if (element.equals(storage[i])) {
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


