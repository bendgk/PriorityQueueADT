package com.benjamin;

public class CircularDoublyLinkedList<T> {
    private Node<T> start;
    private int size;

    CircularDoublyLinkedList() {
        size = 0;
    }

    /**
     * Insert DoublyLinkedNode after a given DoublyLinked Node
     * @param node DoublyLinkedNode to insert after
     * @param newNode DoublyLinkedNode to insert
     */
    public void insertAfter(Node<T> node, Node<T> newNode) {
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
    public void insertBefore(Node<T> node, Node<T> newNode) {
        insertAfter(node.getPrev(), newNode);
    }

    /**
     * Append newNode to end of CircularDoublyLinkedList
     * @param data to append
     */
    public void append(T data) {
       append(NodeFactory.createNode(data));
    }

    /**
     * Append node to end of CircularDoublyLinkedList
     * @param node
     */
    public void append(Node<T> node) {
        if(isEmpty()) {
            start = node;
            size++;
        }
        else {
            insertBefore(start, node);
        }
    }

    /**
     * Tries to remove the last node in CicularDoublyLinkedList
     */
    public void pop() {
        remove(start.getPrev());
    }

    /**
     * Removes a given node
     * @param node to remove
     */
    public void remove(Node<T> node) {
        if(node.getNext() == node) {
            start = null;
        }
        else {
            node.getNext().setPrev(node.getPrev());
            node.getPrev().setNext(node.getNext());
            if(node == start) {
                start = node.getNext();
            }
        }
        size--;

        node.clearLinks();
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
        if(!o.isEmpty()) {
            if (getStart() == null) {                        //if this linked list is empty
                start = o.getStart();
            } else {
                getStart().getPrev().setNext(o.getStart());
                o.getStart().getPrev().setNext(getStart());

                Node<T> tempNode = getStart().getPrev();

                getStart().setPrev(o.getStart().getPrev());
                o.getStart().setPrev(tempNode);
            }
            size += o.getSize();
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public Node<T> getStart() {
        return start;
    }

    @Override
    public String toString() {
        String out = "";
        Node<T> node = start;

        for (int i = 0; i < size; i++) {
            out += node.toString();
            node = node.getNext();
        }
        return out;
    }
}
