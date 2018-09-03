package com.benjamin;

public class FibonacciNode<T> extends DoublyLinkedNode<T> {
    private int key;

    //Fibonacci heap attributes
    private FibonacciNode parent;
    private FibonacciNode child;
    private int degree;
    private boolean isMarked;

    FibonacciNode(T data, int priority) {
        super(data);
        setKey(priority);
    }

    //Mess of getters an setters for all attributes
    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }
    public FibonacciNode getParent() { return parent; }
    public void setParent(FibonacciNode parent) { this.parent = parent; }
    public FibonacciNode getChild() { return child; }
    public void setChild(FibonacciNode child) { this.child = child; }
    public int getDegree() { return degree; }
    public void setDegree(int degree) { this.degree = degree; }
    public boolean isMarked() { return isMarked; }
    public void setMarked(boolean marked) { isMarked = marked; }
}
