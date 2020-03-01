package ch.hslu.sw02;

/**
 * @Autohr Simon Müller
 */
public interface StackInterface {

    /**
     * Adds a new element on top of the stack.
     *
     * @param string - the string to add.
     */
    String push(final String string);

    /**
     * Removes and returns the element on top of the stack.
     * @returns the first element.
     */
    String pop();

    /**
     * Returns the number of elements in the stack.
     *
     * @returns the count of elements.
     */
    int size();

    /**
     * Shows if the stack is empty or not.
     *
     * @return true if stack is empty.
     */
    boolean isEmpty();

    /**
     * Shows if the stack is full or not.
     *
     * @return true if stack is full.
     */
    boolean isFull();
}
