package ch.hslu.sw03;

import ch.hslu.sw02.Node;

import java.util.Objects;

public class TreeNode {

    private TreeNode leftChild;
    private TreeNode rightChild;
    private int value;

    public TreeNode(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void leftChild(final TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void rightChild(final TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getLeftChild() {
        return this.leftChild;
    }

    public TreeNode getRightChild() {
        return this.rightChild;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TreeNode)) {
            return false;
        }
        final TreeNode other = (TreeNode) obj;
        return this.value == other.value;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "leftChild = " + leftChild +
                ", rightChild = " + rightChild +
                ", value = " + value +
                '}';
    }
}

