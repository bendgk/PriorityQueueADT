package com.benjamin;

public class FibonacciNode<T> extends DoublyLinkedNode<T> {
    private int key;

    //Fibonacci heap attributes
    private FibonacciNode parent;
    private CircularDoublyLinkedList<T> children;
    private boolean isMarked;

    FibonacciNode(int key, T value) {
        super(value);
        setKey(key);
        children = new CircularDoublyLinkedList<>();
    }

    //Mess of getters an setters for all attributes
    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }
    public FibonacciNode getParent() { return parent; }
    public void setParent(FibonacciNode parent) { this.parent = parent; }
    public CircularDoublyLinkedList<T> getChildren() { return children; }
    public int getDegree() {
        return getChildren().getSize();
    }
    public boolean isMarked() { return isMarked; }
    public void setMarked(boolean marked) { isMarked = marked; }

    @Override
    public String toString() {
        return "| Key: " + getKey() + " Degree: " + getDegree() + " |";
    }
}
