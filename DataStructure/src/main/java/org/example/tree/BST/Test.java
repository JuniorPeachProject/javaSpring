package org.example.tree.BST;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(40);
        bst.insert(20);
        bst.insert(30);
        bst.insert(60);
        bst.preorder(bst.root);
        bst.inorder(bst.root);
        bst.postorder(bst.root);
    }
}
