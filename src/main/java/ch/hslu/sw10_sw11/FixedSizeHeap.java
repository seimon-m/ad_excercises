package ch.hslu.sw10_sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FixedSizeHeap implements IntegerHeap {

    private static final Logger LOG = LogManager.getLogger(FixedSizeHeap.class);
    private int[] array;
    private int size = 0;
    private int tail = 0;

    public FixedSizeHeap(final int size) {
        array = new int[size];
    }

    @Override
    public int getMax() {
        int max;
        if (true) {
            max = array[0];
            LOG.debug(max);
            array[0] = array[tail];
            array[0] = 0;

            LOG.info("Array before rearrange down:");
            for (int i = 0; i < array.length; i++) {
                LOG.info(array[i]);
            }

            rearrangeDown(0);

            LOG.info("Array after rearrange down:");
            for (int i = 0; i < array.length; i++) {
                LOG.info(array[i]);
            }

            tail--;
            size--;
        } else {
            throw new IllegalStateException("heap empty");
        }
        return max;
    }

    @Override
    public void insert(int a) {
        if (!isFull()) {
            array[tail] = a;
            LOG.info("Array before rearrange up:");
            for (int i = 0; i < array.length; i++) {
                LOG.info(array[i]);
            }
            rearrangeUp(tail);
            LOG.info("Array after rearrange up:");
            for (int i = 0; i < array.length; i++) {
                LOG.info(array[i]);
            }
            tail++;
            size++;
        } else {
            throw new IllegalStateException("heap full");
        }

    }

    private void rearrangeUp(int index) {
        int IndexFather = (index - 1) / 2;
        if (array[IndexFather] < array[index] && index > 0) {
            swapElement(IndexFather, index);
            rearrangeUp(IndexFather);
        }
    }

    private void rearrangeDown(int index) {
        int IndexLeftChild = (2 * index) + 1;
        int IndexRightChild = 2 * (index + 1);
        if (array[index] < array[IndexLeftChild] && index < tail) {
            swapElement(IndexLeftChild, index);
            rearrangeDown(IndexLeftChild);
        }
        if (array[index] < array[IndexRightChild] && index < tail) {
            swapElement(IndexRightChild, index);
            rearrangeDown(IndexRightChild);
        }
    }

    private void swapElement(int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
        LOG.info("Index " + indexA + " and " + indexB + " swapped.");
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public boolean isEmpty() {
//        return size == 0;
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
}
