/**
 * @author Benjamin Kosten
 *
 * docstrings are fun, a little too fun.
 */

package com.benjamin;

public class DynamicArray<T> {
    private int size = 0;
    private int capacity = 8;

    private T[] elements;

    /**
     * Initializes a blank elements array
     */
    public DynamicArray() {
        elements = (T[])new Object[capacity];
    }

    /**
     * Initializes elements array from an existing array
     *
     * @param   arr     an array of type T
     */
    public DynamicArray(T[] arr) {
        capacity = arr.length;
        size = arr.length;
        elements = (T[])new Object[capacity];
        System.arraycopy(arr, 0, elements, 0, arr.length);
    }

    public DynamicArray(CircularDoublyLinkedList linkedList) {
        capacity = linkedList.getSize() + 1;
        elements = (T[])new Object[capacity];

        Node<T> node = linkedList.getStart();
        do {
            insert((T)node);
            node = node.getNext();
        } while (node != linkedList.getStart());
    }

    public int size() { return size; }

    /**
     * Get item at position
     *
     * @param   position    position to insert at
     * @returns             element
     */
    public T get(int position){
        if(position >= size) { throw new ArrayIndexOutOfBoundsException("Index " + position + " is out of bounds!"); }
        return elements[position];
    }

    /**
     * Increases capacity of elements if necessary
     */
    private void ensureCapacity() {
        if(size == capacity) {
            capacity *= 2;
            T[] buffer = (T[])new Object[capacity];
            System.arraycopy(elements, 0, buffer, 0, elements.length);
            elements = buffer;
        }
    }

    /**
     * Inserts an element at the end of elements and increases its size accordingly
     *
     * @param   element     element to insert
     */
    public void insert(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Inserts an element at a given position into elements and pushes all elements right of position by one
     * resizing elements accordingly
     *
     * @param   element     element to insert
     * @param   position    position to insert at
     */
    public void insert(T element, int position) {
        ensureCapacity();
        System.arraycopy(elements, position, elements, position + 1, size - position);
        elements[position] = element;
        size++;
    }

    /**
     * Removes element at position T, shifting all subsequent elements left by one
     *
     * @param   position    index of element
     * @return              removed element
     */
    public T pop(int position) {
        T out = get(position);
        System.arraycopy(elements, position + 1, elements, position, size - position - 1);
        size--;

        return out;
    }

    /**
     * Removes first occurrence of element
     *
     * @param   element     element to remove
     * @return              index of item removed or -1 if null
     */
    public int remove(T element) {
        for (int i = 0; i < size; i++) {
            if(get(i) == element) {
                pop(i);
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        String out = new String("[");
        for (int i = 0; i < size - 1; i++) {
            out += get(i).toString() + ", ";
        }
        return out + get(size - 1).toString() +  "]";
    }
}
