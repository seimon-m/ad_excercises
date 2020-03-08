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
        node05.leftChild(node03);
        node03.leftChild(node01);
        node03.rightChild(node04);
        node05.rightChild(node06);
        node06.rightChild(node08);
        node08.leftChild(node07);
        node08.rightChild(node09);
        node09.rightChild(node10);
        node10.rightChild(node12);
    }

    public TreeNode getRoot() {
        return this.root;
    }

    @Override
    public boolean insert(TreeNode root, int element) {
        LOG.debug(root.toString());
        if (this.root == null) {
            this.root = new TreeNode(element);
            return true;
        }

        if (element == root.getValue()) {
            return true;
        }
        if (element < root.getValue()) {
            if (root.getLeftChild() == null) {
                root.leftChild(new TreeNode(element));
                return true;
            }
            return insert(root.getLeftChild(), element);
        }
        if (element > root.getValue()) {
            if (root.getRightChild() == null) {
                root.leftChild(new TreeNode(element));
                return true;
            }
            return insert(root.getRightChild(), element);
        }
        return false;
    }

    @Override
    public boolean remove(int element) {
        return false;
    }

    @Override
    public boolean search(TreeNode root, int element) {
        LOG.debug(root.toString());
        if (root == null) {
            return false;
        }
        if (element == root.getValue()) {
            return true;
        }
        if (element < root.getValue()) {
            if (root.getLeftChild() == null) {
                return false;
            }
            return search(root.getLeftChild(), element);
        }
        if (element > root.getValue()) {
            if (root.getRightChild() == null) {
                return false;
            }
            return search(root.getRightChild(), element);
        }
        return false;
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
}
