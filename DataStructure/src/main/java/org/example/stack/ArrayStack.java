package org.example.stack;

public class ArrayStack<E> implements StackInterface<E>{
    private E[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.stack = (E[]) new Object[DEFAULT_CAPACITY];
        this.topIndex = -1;
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int n) {
        this.stack = (E[]) new Object[n];
        this.topIndex = -1;
    }

    @Override
    public void push(E newItem) {
        if (isFull()) throw new IllegalStateException("스택에 빈 공간이 없습니다.");
        stack[++topIndex] = newItem;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        return stack[topIndex--];
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void popAll() {
        stack = (E[]) new Object[stack.length];
        topIndex = -1;
    }

    public boolean isFull() {
        return topIndex + 1 >= DEFAULT_CAPACITY;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i <= topIndex; i++) {
            if (stack[i] != null) {
                res.append(stack[i].toString());
                if (i < topIndex) {
                    res.append(", ");
                }
            }
        }
        res.append("]");
        return res.toString();
    }
}
