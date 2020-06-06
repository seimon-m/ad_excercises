package ch.hslu.sw03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinarySearchTree implements BinaryTreeInterface {

    private static final Logger LOG = LogManager.getLogger(BinarySearchTree.class);
    private static int TREE_ORDER = 2;
    private TreeNode root;

    public BinarySearchTree() {
        TreeNode node01 = new TreeNode(1);
        TreeNode node03 = new TreeNode(3);
        TreeNode node04 = new TreeNode(4);
        TreeNode node05 = new TreeNode(5);
        TreeNode node06 = new TreeNode(6);
        TreeNode node07 = new TreeNode(7);
        TreeNode node08 = new TreeNode(8);
        TreeNode node09 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node12 = new TreeNode(12);

        this.root = node05;
        node05.setLeftChild(node03);
        node03.setLeftChild(node01);
        node03.setRightChild(node04);
        node05.setRightChild(node06);
        node06.setRightChild(node08);
        node08.setLeftChild(node07);
        node08.setRightChild(node09);
        node09.setRightChild(node10);
        node10.setRightChild(node12);
    }

    @Override
    public boolean insert(TreeNode root, int element) {
        if (root.getValue() > element) {
            if (root.hasLeftChild()) {
                return insert(root.getLeftChild(), element);
            } else {
                root.setLeftChild(new TreeNode(element));
                return true;
            }
        } else if (root.getValue() <= element) {
            if (root.hasRightChild()) {
                return insert(root.getRightChild(), element);
            } else {
                root.setRightChild(new TreeNode(element));
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(int element) {
        return false;
    }

    @Override
    public boolean search(TreeNode root, int element) {
        if (root.getValue() == element) {
            return true;
        } else if (root.getValue() > element && root.hasLeftChild()) {
            return search(root.getLeftChild(), element);
        } else if (root.getValue() <= element && root.hasRightChild()) {
            return search(root.getRightChild(), element);
        } else {
            return false;
        }
    }

    @Override
    public int getOrder() {
        return TREE_ORDER;
    }

    @Override
    public int getDegree(TreeNode node) {
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void inorder(TreeNode root) {
        if (root.hasLeftChild()) {
            inorder(root.getLeftChild());
        }
        LOG.info("Traversed Node: " + root.getValue());
        if (root.hasRightChild()) {
            inorder(root.getRightChild());
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
