package com.benjamin;

abstract class Node<T> {
    private Node<T> prev;
    private Node<T> next;
    private T data;

    public Node<T> getPrev() { return prev; }
    public Node<T> getNext() { return next; }
    public T getData() { return data; }

    public void setPrev(Node<T> prev) { this.prev = prev; }
    public void setNext(Node<T> next) { this.next = next; }
    public void setData(T data) { this.data = data; }

    public void test() {return;}
}