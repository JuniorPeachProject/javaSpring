package org.example.tree;

import org.example.tree.BST.BinarySearchTree;
import org.example.tree.BST.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree bst;
    @BeforeEach
    public void beforeEach() {
        bst = new BinarySearchTree();
    }

    @DisplayName("정수 Binary Search Tree에 정수가 Search Tree 조건에 맞게 들어간다.")
    @Test
    void insert() {
        // given
        bst.insert(10);
        bst.insert(20);
        bst.insert(50);
        bst.insert(80);
        bst.insert(90);
        bst.insert(75);
        bst.insert(30);
        // when & then
        assertTrue(isBST(bst.getRoot(), null, null));
    }

    @Test
    void searchExistingKey() {
        bst.setRoot(new TreeNode(10,
            new TreeNode(5, null, null),
            new TreeNode(20,
                new TreeNode(15, null, null),
                new TreeNode(25, null, null))));
        // 트리에 존재하는 값을 찾는 경우
        assertNotNull(bst.search(10));
        assertNotNull(bst.search(20));
        assertNotNull(bst.search(5));
        assertNotNull(bst.search(15));
        assertNotNull(bst.search(25));
    }

    @Test
    void searchNonExistingKey() {
        bst.setRoot(new TreeNode(10,
            new TreeNode(5, null, null),
            new TreeNode(20,
                new TreeNode(15, null, null),
                new TreeNode(25, null, null))));
        // 트리에 존재하지 않는 값을 찾는 경우
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bst.search(30);
        });
        assertEquals("트리에 있는 key 값을 넣어주세요", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            bst.search(0);
        });
        assertEquals("트리에 있는 key 값을 넣어주세요", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            bst.search(17);
        });
        assertEquals("트리에 있는 key 값을 넣어주세요", exception.getMessage());
    }

    @Test
    void searchInEmptyTree() {
        // 비어있는 트리에서 값을 찾는 경우
        BinarySearchTree emptyTree = bst;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            emptyTree.search(10);
        });
        assertEquals("트리에 있는 key 값을 넣어주세요", exception.getMessage());
    }

    boolean isBST(TreeNode node, Comparable min, Comparable max) {
        if (node == null) return true;
        if (min != null && node.key.compareTo(min) <= 0) return false;
        if (max != null && node.key.compareTo(max) >= 0) return false;
        return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
    }
}