package com.benjamin;

public class DoublyLinkedNode<T> extends Node<T>{

    DoublyLinkedNode(T data) {
        setPrev(this);
        setNext(this);
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
