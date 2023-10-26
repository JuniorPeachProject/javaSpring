package org.example.list;

public class Node<E> {
    public E item;
    public Node<E> next;

    public Node(E item) {
        this.item = item;
        next = null;
    }

    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }
}
