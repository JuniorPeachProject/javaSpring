package org.example.tree.AVL;

import org.example.tree.IndexInterface;

public class AVLTree implements IndexInterface<AVLNode> {
    private AVLNode root;
    static final AVLNode NIL = new AVLNode(null, null, null, 0);

    @Override
    public AVLNode search(Comparable x) {
        return null;
    }

    @Override
    public void insert(Comparable x) {

    }

    @Override
    public void delete(Comparable x) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
