package com.benjamin;

public class CircularDoublyLinkedList<T extends Comparable<T>> {
    private DoublyLinkedNode<T> start;
    private int size;

    CircularDoublyLinkedList() {
        start = new DoublyLinkedNode<>();
        size = 1;
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
        insertBefore(start, new DoublyLinkedNode<T>(data));
    }

    /**
     * Removes a given node
     * @param node to remove
     */
    public void remove(DoublyLinkedNode<T> node) {
        assert node != start: "Cannot remove start node!";
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
    }

    public boolean isEmpty() {
        return size > 1;
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

        if (size > 1) {
            DoublyLinkedNode<T> node = start.getNext();
            out += " <-> ";

            do {
                out += node.toString() + " <-> ";
                node = node.getNext();
            } while (node != start.getPrev());

            out += start.getPrev().toString();
            out += "\n  ^";
            out += new String(new char[getSize() - 1]).replace("\0", "__________").substring(0, (getSize() - 1) * 10 - 1);
            out += "|";
        }

        return out;
    }
}
