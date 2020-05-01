package ch.hslu.sw10_sw11;

public interface IntegerHeap {

    /**
     * @returns and removes max value (root) from the tree.
     */
    int getMax();

    /**
     * @param a value to insert the tree.
     */
    void insert(final int a);

    /**
     * @return true if heap is full.
     */
    boolean isFull();

    /**
     * @return true if heap is empty.
     */
    boolean isEmpty();
}
