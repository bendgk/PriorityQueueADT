package com.benjamin;

abstract class Node<T, N> {
    private N prev;
    private N next;
    private T data;

    public N getPrev() { return prev; }
    public N getNext() { return next; }
    public T getData() { return data; }

    public void setPrev(N prev) { this.prev = prev; }
    public void setNext(N next) { this.next = next; }
    public void setData(T data) { this.data = data; }
}