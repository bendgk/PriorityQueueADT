package com.benjamin;

public class NodeFactory {
    public static <T> Node createNode(T data) {
        return new DoublyLinkedNode<T>(data);
    }

    public static <T> Node createNode(T data, int key) {
        return new FibonacciNode<T>(key, data);
    }
}
