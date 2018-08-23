package com.benjamin;

public class Main {

    public static void main(String[] args) {
        //testing DynamicArray
        /*
        DynamicArray<Integer> arr = new DynamicArray<>();
        for (int i = 0; i < 10; i++) {
            arr.insert(i);
        }

        arr.pop(2);
        System.out.println(arr);
        */

        CircularDoublyLinkedList<Integer> linkedList = new CircularDoublyLinkedList<>();
        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(1);


        System.out.println(linkedList);
    }
}
