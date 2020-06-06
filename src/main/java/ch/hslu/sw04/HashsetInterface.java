package ch.hslu.sw04;

public interface HashsetInterface {

    /**
     * @param element to add to the hashset
     * @return true if it was sucessfull
     */
    boolean add(final Integer element);

    /**
     * @param element to remove from the hashset
     * @return the removed element
     */
    Integer remove(final Integer element);

    /**
     * @param element to search for
     * @return true if hashset contains the element
     */
    boolean search(final Integer element);

    /**
     * @return the actual size of the hashset
     */
    int getSize();
}
