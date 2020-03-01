package ch.hslu.sw02;

public interface QueueInterface {

    /**
     * Adds an element at the end of the queue.
     *
     * @param element - the element to add.
     */
    void add(final char element);

    /**
     * Returns and removes the head element of the queue.
     *
     * @returns the head of the queue.
     */
    char poll();

    /**
     * Returns the number of elements in the queue.
     *
     * @returns the count of elements.
     */
    int size();
}
