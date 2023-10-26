package org.example.queue;

import org.example.list.Node;

public class LinkedQueue<E> implements QueueInterface<E> {
    private Node<E> tail;
    private final E ERROR = null;
    public LinkedQueue() {
        tail = null;
    }

    @Override
    public void enqueue(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            newNode.next = newNode;
            tail = newNode;
        }
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        Node<E> front = tail.next;
        if (front == tail) tail = null;
        else tail.next = front.next;
        return front.item;
    }

    @Override
    public E front() {
        if (isEmpty()) return null;
        return tail.next.item;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public void dequeueAll() {
        tail = null;
    }
}
