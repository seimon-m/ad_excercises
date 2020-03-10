package ch.hslu.sw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void testSearch1() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        assertEquals(true, tree.search(root, 12));
    }

    @Test
    void testSearch2() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        assertEquals(true, tree.search(root, 7));
    }

    @Test
    void testSearch3() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        assertEquals(true, tree.search(root, 3));
    }

    @Test
    void testSearch4() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        assertEquals(false, tree.search(root, 2));
    }

    @Test
    void testInsert1() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        assertEquals(true, tree.insert(root, 2));
    }

    @Test
    void testInsert2() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(tree.getRoot(), 2);
        assertEquals(true, tree.search(tree.getRoot(), 2));
    }

    @Test
    void testInsert3() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        tree.insert(root, 11);
        assertEquals(true, tree.search(root, 11));
    }

    @Test
    void testInsert4() {
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.getRoot();
        tree.insert(root, 13);
        assertEquals(true, tree.search(root, 13));
    }
}