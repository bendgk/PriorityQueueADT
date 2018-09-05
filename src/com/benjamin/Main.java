package com.benjamin;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < 20; i++) {
            priorityQueue.insert(i*2, i);
        }

        priorityQueue.insert(1000, 20000);
        priorityQueue.insert(-1, 200);

        System.out.println(priorityQueue);

        for (int i = 0; i < 22; i++) {
            System.out.println(priorityQueue.removeMax());
        }

        System.out.println(priorityQueue.removeMax()); //Raises EmptyPriorityQueueException RuntimeException

    }
}
