package com.benjamin;

public interface FibonacciHeapInterface<T extends Comparable<T>> {
    Comparable<T> findMaximum();
    void merge();
    void insert(Comparable<T> data);
    Comparable<T> extractMaximum();
}
