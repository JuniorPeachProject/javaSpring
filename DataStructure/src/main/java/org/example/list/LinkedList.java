package org.example.list;

public class LinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numItems;

    private static final int NOT_FOUND = -87654321;

    public LinkedList() {
        numItems = 0;
        head = new Node<>(null, null);
    }

    public Node<E> getNode(int index) {
        if (index < -1 || index > numItems -1) return null;
        Node<E> currentNode = head;
        for (int i=0; i<= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > numItems) return;
        Node<E> prevNode = getNode(index - 1);
        prevNode.next = new Node<>(item, prevNode.next);
        numItems++;
    }

    @Override
    public void append(E item) {
        Node<E> prevNode = head;
        while (prevNode.next != null) {
            prevNode = prevNode.next;
        }
        prevNode.next = new Node<>(item, null);
        numItems++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= numItems) return null;
        Node<E> prevNode = getNode(index - 1);
        Node<E> currentNode = prevNode.next;
        prevNode.next = currentNode.next;
        numItems --;
        return currentNode.item;
    }

    @Override
    public boolean removeItem(E item) {
        Node<E> currentNode = head;
        Node<E> prevNode;
        for (int i=0; i< numItems; i++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            if (((Comparable)(currentNode.item)).compareTo(item) == 0) {
                prevNode.next = currentNode.next;
                numItems --;
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > numItems - 1) return null;
        return getNode(index).item;
    }

    @Override
    public void set(int index, E item) {
        if (index < 0 || index > numItems - 1)
            throw new IllegalArgumentException("유효한 인덱스 값을 넣어주세요.");
        getNode(index).item = item;
    }

    @Override
    public int indexOf(E item) {
        Node<E> currentNode = head;
        for (int i = 0; i < numItems; i++) {
            currentNode = currentNode.next;
            if (((Comparable)(currentNode.item)).compareTo(item) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        head = new Node<>(null, null);
    }
}
