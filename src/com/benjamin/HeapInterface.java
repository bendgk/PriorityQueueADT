package com.benjamin;

public interface HeapInterface<T extends Comparable<T>> {
    void insert(Comparable<T> item);
    void replace();

    Comparable<T> findMax();
    Comparable<T> extract();

}

