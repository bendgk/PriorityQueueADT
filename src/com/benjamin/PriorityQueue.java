package com.benjamin;

import com.benjamin.exceptions.EmptyPriorityQueueException;

public class PriorityQueue<T> {
    private FibonacciHeap<T> heap;

    PriorityQueue() {
        heap = new FibonacciHeap<>();
    }

    /**
     * return true iff the PriorityQueue is empty
     * @return boolean on the state of PriorityQueue
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * add with priority p to the PriorityQueue
     * @param p integer specifying priority
     * @param data generic data
     */
    public void insert(int p, T data) {
        heap.insert(p, data);
    }

    /**
     * remove and return the highest priority from the PriorityQueue (error if the PriorityQueue is empty)
     *
     * @return generic data with highest priority
     * @throws EmptyPriorityQueueException
     */
    public T removeMax() throws  EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("PriorityQueue is empty!");
        }
        return heap.extractMax().getData();

    }

    /**
     * return the highest priority from the PriorityQueue, but do not remove it (error if the PriorityQueue is empty)
     * @return generic data with highest priority
     * @throws EmptyPriorityQueueException
     */
    public T getMax() throws  EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("PriorityQueue is empty!");
        }
        return heap.getMax().getData();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
