package ch.hslu.sw03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class TreeNode {

    private static final Logger LOG = LogManager.getLogger(TreeNode.class);

    private TreeNode leftChild;
    private TreeNode rightChild;
    private int value;

    public TreeNode(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setLeftChild(final TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(final TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getLeftChild() {
        return this.leftChild;
    }

    public TreeNode getRightChild() {
        return this.rightChild;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
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
                " value = " + value +
                ", leftChild = " + leftChild +
                ", rightChild = " + rightChild +
                '}';
    }
}

