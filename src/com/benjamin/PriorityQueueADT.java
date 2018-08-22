package com.benjamin;

public interface PriorityQueueADT<T extends Comparable<T>> {
    boolean isEmpty(); //return true iff the PriorityQueue is empty
    void insert(Comparable<T> p); //add with priority p to the PriorityQueue
    Comparable<T> removeMax(); //remove and return the highest priority from the PriorityQueue (error if the PriorityQueue is empty)
    Comparable<T> getMax(); //return the highest priority from the PriorityQueue, but do not remove it (error if the PriorityQueue is empty)
}
