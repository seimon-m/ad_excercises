package ch.hslu.sw03;

public interface BinaryTreeInterface {

    /**
     * Add the given element to the tree.
     *
     * @param element the element to add
     * @return if the element has been added
     */
    public boolean insert(int element);

    /**
     * Remove the given element from the tree.
     *
     * @param element the element to remove
     * @return if the element has been removed
     */
    public boolean remove(int element);

    /**
     * Returns true if this tree contains the specified element.
     *
     * @param element the element to search for
     * @return whether the element was found
     */
    public boolean search(int element);

    /**
     * Returns the maximum allowed children for each node.
     *
     * @return the maximum allowed children for each node.
     */
    public int getOrder();

    /**
     * Get the degree for the node of the given element.
     * The degree specifies the amount of children a given node has.
     *
     * @param node
     * @return the amount of children the node has.
     */
    public int getDegree(TreeNode node);

    /**
     * Returns the weight of the tree.
     * The weight is the amount of nodes the tree has access to.
     *
     * @return the tree's weight
     */
    public int getWeight();
}
