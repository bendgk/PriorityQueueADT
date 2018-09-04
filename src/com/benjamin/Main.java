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
        /*
        CircularDoublyLinkedList<Integer> linkedList = new CircularDoublyLinkedList<Integer>(NodeType.DOUBLY_LINKED_NODE);
        CircularDoublyLinkedList<Integer> linkedList1 = new CircularDoublyLinkedList<Integer>(NodeType.DOUBLY_LINKED_NODE);
        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(1);

        linkedList1.append(7);
        linkedList1.append(8);
        linkedList.remove(linkedList.getStart());

        linkedList.concat(linkedList1);
        System.out.println(linkedList);

        //Iterate forwards thru list
        /*
        DoublyLinkedNode<Integer> node = linkedList.getStart();

        do {
            System.out.print(node + " ");
            node = node.getNext();
        } while (node != linkedList.getStart());

        DoublyLinkedNode<Integer> fbNode = new FibonacciNode<>(5,0);
        FibonacciNode<Integer> fbNode2 = new FibonacciNode<>(5,0);
        //fbNode.setParent(fbNode2);

        //System.out.println(fbNode.getParent());
        */

        FibonacciHeap<Integer> test = new FibonacciHeap<>();
        for (int i = 0; i < 100; i++) {
            test.insert(i, 1337);
        }


        for (int i = 0; i < 100; i++) {
            System.out.println(test.extractMax() + " size: " + test.getSize());
        }


        //System.out.println(test);

    }
}
