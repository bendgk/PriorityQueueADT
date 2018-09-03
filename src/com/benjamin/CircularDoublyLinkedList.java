package com.benjamin;

import com.benjamin.exceptions.RemoveStartNodeException;

public class CircularDoublyLinkedList<T> {
    private Node<T> start;
    private int size;
    private NodeType nodeType;

    CircularDoublyLinkedList(NodeType nodeType) {
        this.nodeType = nodeType;
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
       append(NodeFactory.createNode(nodeType, data));
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
     * @throws RemoveStartNodeException
     */
    public void pop() {
        remove(start.getPrev());
    }

    /**
     * Removes a given node
     * @param node to remove
     */
    public void remove(Node<T> node) throws RemoveStartNodeException {
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

        Node<T> tempNode = getStart().getPrev();

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

    public Node<T> getStart() {
        return start;
    }

    public NodeType getNodeType() { return nodeType; }

    @Override
    public String toString() {
        String out = start.toString();

        if (size > 0) {
            Node<T> node = start.getNext();
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
