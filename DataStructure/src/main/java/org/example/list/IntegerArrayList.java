package org.example.list;

public class IntegerArrayList implements IntegerListInterface{
    private Integer[] item;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;

    public IntegerArrayList(int n) {
        this.item = new Integer[n];
        this.numItems = 0;
    }

    public IntegerArrayList() {
        this.item = new Integer[DEFAULT_CAPACITY];
        this.numItems = 0;
    }

    @Override
    public void add(int index, Integer x) {
        if (numItems >= item.length || index < 0 || index > numItems) {
            throw new IllegalArgumentException("올바른 인덱스가 아닙니다.");
        }
        for (int i = numItems - 1; i >= index; i--) {
            item[i+1] = item[i];
        }
        item[index] = x;
        numItems++;
    }

    @Override
    public void append(Integer x) {
        if (numItems >= item.length) {
            throw new IllegalStateException("리스트에 빈 공간이 없습니다.");
        }
        item[numItems++] = x;
    }

    @Override
    public Integer remove(int index) {
        if (isEmpty() || index < 0 || index > numItems - 1) {
            return null;
        }
        Integer foundItem = this.item[index];
        for (int i = index; i <= numItems -2; i++) {
            item[i] = item[i+1];
        }
        numItems--;
        return foundItem;
    }

    @Override
    public boolean removeItem(Integer x) {
        int k = 0;
        while (k < numItems && item[k].compareTo(x) != 0) {
            k++;
        }
        if (k == numItems) {
            return false;
        }
        for (int i=k; i<= numItems - 2; i++) {
            item[i] = item[i+1];
        }
        numItems--;
        return true;
    }

    @Override
    public Integer get(int index) {
        if (index >= 0 && index <= numItems -1) {
            return item[index];
        }
        return null;
    }

    @Override
    public void set(int index, Integer x) {
        if (index >= 0 && index <= numItems -1) {
            item[index] = x;
        }
        throw new IllegalArgumentException("유효한 인덱스 값을 넣어주세요");
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
        item = new Integer[item.length];
        numItems = 0;
    }
}
