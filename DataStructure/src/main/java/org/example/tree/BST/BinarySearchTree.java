package org.example.tree.BST;


import org.example.tree.IndexInterface;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BinarySearchTree implements IndexInterface<TreeNode> {
    public TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public BinarySearchTree() {
        root = null;
    }

    private TreeNode searchItem(TreeNode tNode, Comparable searchKey) {
        if (tNode == null) return null;
        if (searchKey.compareTo(tNode.key) == 0) {
            return tNode;
        }
        if (searchKey.compareTo(tNode.key) < 0) {
            return searchItem(tNode.left, searchKey);
        }
        return searchItem(tNode.right, searchKey); // > 0 인 상황
    }

    @Override
    public TreeNode search(Comparable searchKey) {
        TreeNode searched = searchItem(root, searchKey);
        if (searched == null)
            throw new IllegalArgumentException("트리에 있는 key 값을 넣어주세요");
        return searched;
    }

    private TreeNode insertItem(TreeNode tNode, Comparable newItem) {
        if (tNode == null)
            tNode = new TreeNode(newItem, null, null);
        else if (newItem.compareTo(tNode.key) < 0) {
            tNode.left = insertItem(tNode.left, newItem);
        } else {
            tNode.right = insertItem(tNode.right, newItem);
        }
        return tNode;
    }

    @Override
    public void insert(Comparable newKey) {
        root = insertItem(root, newKey);
    }

    private TreeNode deleteItem(TreeNode tNode, Comparable searchKey) {
        if (tNode == null) return null;
        if (searchKey == tNode.key)
            tNode = deleteNode(tNode);
        else if (searchKey.compareTo(tNode.key) < 0) {
            tNode.left = deleteItem(tNode.left, searchKey);
        } else {
            tNode.right = deleteItem(tNode.right, searchKey);
        }
        return tNode;
    }

    private TreeNode deleteNode(TreeNode tNode) {
        // 1. 리프 노드 지우기
        if (tNode.left == null && tNode.right == null) {
            return null;
        } else if (tNode.left == null) { // 2. 오른쪽 노드만 존재
            return tNode.right;
        } else if (tNode.right == null) { // 3. 왼쪽 노드만 존재
            return tNode.left;
        } else { // 4. 두 자식 노드 다 존재.
            returnPair returnPair = deleteMinItem(tNode.right);
            tNode.key = returnPair.key;
            tNode.right = returnPair.node;
            return tNode;
        }
    }

    private returnPair deleteMinItem(TreeNode tNode) {
        if (tNode.left == null)
            return new returnPair(tNode.key, tNode.right);
        returnPair rPair = deleteMinItem(tNode.left);
        tNode.left = rPair.node;
        rPair.node = tNode;
        return rPair;
    }

    private static class returnPair {
        private Comparable key;
        private TreeNode node;

        public returnPair(Comparable it, TreeNode nd) {
            key = it;
            node = nd;
        }
    }

    @Override
    public void delete(Comparable x) {
        root = deleteItem(root, x);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    public void preorder(TreeNode nd) {
        System.out.print(nd+" ");
        if (nd.left != null)
            preorder(nd.left);
        if (nd.right != null)
            preorder(nd.right);
    }

    public void inorder(TreeNode nd) {
        if (nd.left != null)
            inorder(nd.left);
        System.out.print(nd+" ");
        if (nd.right != null)
            inorder(nd.right);
    }

    public void postorder(TreeNode nd) {
        if (nd.left != null)
            postorder(nd.left);
        if (nd.right != null)
            postorder(nd.right);
        System.out.print(nd+" ");
    }

}
