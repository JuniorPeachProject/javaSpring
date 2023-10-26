package org.example.list;

public interface ListInterface<E> {
    public void add(int index, E item);
    public void append(E item);
    public E remove(int index);
    public boolean removeItem(E item);
    public E get(int index);
    public void set(int index, E item);
    public int indexOf(E item);
    public int len();
    public boolean isEmpty();
    public void clear();
}
