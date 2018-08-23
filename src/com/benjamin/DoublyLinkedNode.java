package com.benjamin;

public class DoublyLinkedNode<T> {
    private DoublyLinkedNode prev;
    private DoublyLinkedNode next;
    private T data;

    DoublyLinkedNode() {
        setPrev(this);
        setNext(this);
        setData(null);
    }

    DoublyLinkedNode(T data) {
        setData(data);
    }

    public DoublyLinkedNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedNode prev) {
        this.prev = prev;
    }

    public DoublyLinkedNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedNode next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        if(getData() != null) {
            return "| " + getData().toString() + " |";
        }
        else {
            return "| ; |";
        }
    }
}
