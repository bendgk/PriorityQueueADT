package com.benjamin;

import com.benjamin.exceptions.RemoveStartNodeException;

public class CircularDoublyLinkedList<T> {
    private DoublyLinkedNode<T> start;
    private int size;

    CircularDoublyLinkedList() {
        start = new DoublyLinkedNode<T>();
        size = 0;
    }

    /**
     * Insert DoublyLinkedNode after a given DoublyLinked Node
     * @param node DoublyLinkedNode to insert after
     * @param newNode DoublyLinkedNode to insert
     */
    public void insertAfter(DoublyLinkedNode<T> node, DoublyLinkedNode<T> newNode) {
        newNode.setNext(node.getNext());
        newNode.setPrev(node);
        node.getNext().setPrev(newNode);
        node.setNext(newNode);

        size++;
    }

    /**
     * Insert DoublyLinkedNode after a given DoublyLinked Node
     * @param node DoublyLinkedNode to insert after
     * @param newNode DoublyLinkedNode to insert
     */
    public void insertBefore(DoublyLinkedNode<T> node, DoublyLinkedNode<T> newNode) {
        insertAfter(node.getPrev(), newNode);
    }

    /**
     * Append newNode to end of CircularDoublyLinkedList
     * @param data to append
     */
    public void append(T data) {
        if(isEmpty()) {
            start.setData(data);
            size++;
        }
        else {
            insertBefore(start, new DoublyLinkedNode<T>(data));
        }
    }

    /**
     * Tries to remove the last node in CicularDoublyLinkedList
     * @throws RemoveStartNodeException
     */
    public void pop() {
        remove(start.getPrev());
    }

    /**
     * Removes a given node
     * @param node to remove
     */
    public void remove(DoublyLinkedNode<T> node) throws RemoveStartNodeException {
        if(node == start){ throw new RemoveStartNodeException("Cannot remove start node!"); }
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
    }

    /**
     *
     * @param o
     */
    public void concat(CircularDoublyLinkedList<T> o) {
        /*
        the last of this to link to the start of o
        the last of o to the start of this
         */
        getStart().getPrev().setNext(o.getStart());
        o.getStart().getPrev().setNext(getStart());

        DoublyLinkedNode<T> tempNode = getStart().getPrev();

        getStart().setPrev(o.getStart().getPrev());
        o.getStart().setPrev(tempNode);

        size += o.getSize();

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public DoublyLinkedNode<T> getStart() {
        return start;
    }

    @Override
    public String toString() {
        String out = start.toString();

        if (size > 0) {
            DoublyLinkedNode<T> node = start.getNext();
            out += " <-> ";

            do {
                out += node.toString() + " <-> ";
                node = node.getNext();
            } while (node != start.getPrev());

            out += start.getPrev().toString();
            out += "\n  ^";
            out += new String(new char[getSize() - 1]).replace("\0", "__________").substring(0, (getSize() - 1) * 10 - 1);
            out += "^";
        }

        return out;
    }
}
