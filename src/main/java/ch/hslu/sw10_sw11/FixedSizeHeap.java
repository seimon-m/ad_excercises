package ch.hslu.sw10_sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FixedSizeHeap implements IntegerHeap {

    private static final Logger LOG = LogManager.getLogger(FixedSizeHeap.class);
    private int[] array;
    private int size = 0;
    private int tail = -1;
    private int count = 0;

    public FixedSizeHeap(final int size) {
        array = new int[size];
    }

    @Override
    public int getMax() {
        final int max;
        if (!isEmpty()) {
            max = array[0];
            array[0] = array[tail];
            array[tail] = 0;
            LOG.debug("Array before rearrange down:");
            for (int i = 0; i < array.length; i++) {
                LOG.debug(array[i]);
            }
            rearrangeDown(0);
            LOG.debug("Array after rearrange down:");
            for (int i = 0; i < array.length; i++) {
                LOG.debug(array[i]);
            }
            tail--;
            size--;
            return max;
        } else {
            throw new IllegalStateException("heap empty");
        }
    }


    @Override
    public void insert(int a) {
        if (!isFull()) {
            array[tail + 1] = a;
            tail++;
            size++;
            LOG.debug("Array before rearrange up:");
            for (int i = 0; i < array.length; i++) {
                LOG.debug(array[i]);
            }
            rearrangeUp(tail);
            LOG.debug("Array after rearrange up:");
            for (int i = 0; i < array.length; i++) {
                LOG.debug(array[i]);
            }
        } else {
            throw new IllegalStateException("heap full");
        }

    }

    private void rearrangeUp(int index) {
        int indexFather = (index - 1) / 2;
        if (array[indexFather] < array[index] && index > 0) {
            swapElement(indexFather, index);
            rearrangeUp(indexFather);
        }
    }

    private void rearrangeDown(int parentIndex) {
        int indexLeftChild = (2 * parentIndex) + 1;
        int indexRightChild = 2 * (parentIndex + 1);
        if (indexLeftChild < array.length && indexRightChild < array.length) {
            count++;
            LOG.debug("rearrange down durchlauf: " + count);
            if (array[parentIndex] < array[indexLeftChild] && parentIndex <= tail) {
                swapElement(indexLeftChild, parentIndex);
                rearrangeDown(indexLeftChild);
            }
            if (array[parentIndex] < array[indexRightChild] && parentIndex <= tail) {
                swapElement(indexRightChild, parentIndex);
                rearrangeDown(indexRightChild);
            }
        }
    }

    private void swapElement(int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
        LOG.debug("Index " + indexA + " and " + indexB + " swapped.");
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
