package org.example.stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(10);
        System.out.println("ArrayStack created successfully.");

        arrayStack.push(300);
        System.out.println("arrayStack = " + arrayStack);

        arrayStack.push(200);
        System.out.println("arrayStack = " + arrayStack);

        arrayStack.push(100);
        System.out.println("arrayStack = " + arrayStack);

        arrayStack.pop();
        System.out.println("arrayStack = " + arrayStack);

        arrayStack.pop();
        System.out.println("arrayStack = " + arrayStack);

        arrayStack.push(204);
        System.out.println("arrayStack = " + arrayStack);

        arrayStack.popAll();
        System.out.println("arrayStack = " + arrayStack);
    }
}
