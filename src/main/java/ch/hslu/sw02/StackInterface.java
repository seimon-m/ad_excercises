package ch.hslu.sw02;

/**
 * @Autohr Simon Müller
 */
public interface StackInterface {

    /**
     * Adds a new element on top of the stack.
     * @param string to add.
     */
    void push(final String string);

    /**
     * Removes and returns the element on top of the stack.
     * @return the first element.
     */
    String pop();

    /**
     * Returns the number of elements in the stack.
     * @return the count of elements.
     */
    int size();

    /**
     * Shows if the stack is empty or not.
     * @return true if the stack is empty.
     */
    boolean isEmpty();
}
