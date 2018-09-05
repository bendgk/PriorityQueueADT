package com.benjamin;

import com.benjamin.exceptions.EmptyPriorityQueueException;

public class PriorityQueue<T> {
    private FibonacciHeap<T> heap;

    PriorityQueue() {
        heap = new FibonacciHeap<>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void insert(int p, T data) {
        heap.insert(p, data);
    }

    public T removeMax() {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("PriorityQueue is empty!");
        }
        return heap.extractMax().getData();

    }

    public T getMax() {
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
