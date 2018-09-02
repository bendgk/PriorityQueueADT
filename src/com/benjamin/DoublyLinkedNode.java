package com.benjamin;

public class DoublyLinkedNode<T> extends Node<T, DoublyLinkedNode<T>>{
    DoublyLinkedNode() {
        setPrev(this);
        setNext(this);
        setData(null);
    }

    DoublyLinkedNode(T data) {
        setData(data);
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
