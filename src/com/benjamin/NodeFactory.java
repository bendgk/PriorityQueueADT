package com.benjamin;

public class NodeFactory {
    public static <T> Node createNode(NodeType nodeType, T data) {
        switch (nodeType) {
            case DOUBLY_LINKED_NODE:
                return new DoublyLinkedNode<T>(data);
            case FIBONACCI_NODE:
                return new FibonacciNode<T>(data, 0);
            default:
                //should never occur
                return null;
        }
    }
}
