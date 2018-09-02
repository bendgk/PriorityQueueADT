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

        CircularDoublyLinkedList<Integer> linkedList = new CircularDoublyLinkedList<Integer>();
        CircularDoublyLinkedList<Integer> linkedList1 = new CircularDoublyLinkedList<Integer>();
        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(1);

        linkedList1.append(7);
        linkedList1.append(8);

        linkedList.concat(linkedList1);
        System.out.println(linkedList);

        //Iterate forwards thru list
        DoublyLinkedNode<Integer> node = linkedList.getStart();

        do {
            System.out.print(node + " ");
            node = node.getNext();
        } while (node != linkedList.getStart());
    }
}
