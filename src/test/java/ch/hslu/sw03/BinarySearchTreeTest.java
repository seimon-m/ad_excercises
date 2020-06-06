package ch.hslu.sw03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private static final Logger LOG = LogManager.getLogger(BinarySearchTreeTest.class);

    @Test
    void testSearch1() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        assertTrue(tree.search(root, 12));
    }

    @Test
    void testSearch2() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        assertTrue(tree.search(root, 7));
    }

    @Test
    void testSearch3() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        assertTrue(tree.search(root, 3));
    }

    @Test
    void testSearch4() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        assertFalse(tree.search(root, 2));
    }

    @Test
    void testInsert1() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        assertTrue(tree.insert(root, 2));
    }

    @Test
    void testInsert2() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(tree.getRoot(), 2);
        assertTrue(tree.search(tree.getRoot(), 2));
    }

    @Test
    void testInsert3() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        tree.insert(root, 11);
        LOG.debug(tree.toString());
        assertTrue(tree.search(root, 11));
    }

    @Test
    void testInsert4() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        tree.insert(root, 13);
        assertTrue(tree.search(root, 13));
    }

    @Test
    void testInorder() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        tree.inorder(root);
    }
}