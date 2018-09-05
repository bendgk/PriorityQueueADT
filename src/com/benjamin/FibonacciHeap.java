package com.benjamin;

public class FibonacciHeap<T> {
    private FibonacciNode<T> max;
    private int size = 0;
    private CircularDoublyLinkedList<T> roots;

    FibonacciHeap() {
        roots = new CircularDoublyLinkedList<T>();
    }

    FibonacciHeap(FibonacciNode<T> startNode) {
        roots = new CircularDoublyLinkedList<T>();
        roots.append(startNode);
        max = startNode;
        size++;
    }

    public void merge(FibonacciHeap<T> o) {
        if(o.getMax().getKey() > getMax().getKey()) {
            setMax(o.getMax());
        }

        roots.concat(o.roots);
        size += o.size;
    }

    public void insert(FibonacciNode<T> node) {
        if(isEmpty()) {
            setMax(node);
        }
        else if(node.getKey() > getMax().getKey()) {
            setMax(node);
        }

        roots.append(node);
        size++;
    }

    public void insert(int key, T value) {
        insert(new FibonacciNode<T>(key, value));
    }

    public FibonacciNode<T> extractMax() {
        if(isEmpty()) {
            return null;
        }

        FibonacciNode<T> tempMax = getMax();
        roots.remove(tempMax);

        if(!tempMax.getChildren().isEmpty()) {
            ((FibonacciNode<T>) tempMax.getChildren().getStart()).setParent(null); //part of root list so no parent
            roots.concat(tempMax.getChildren());
        }

        size--;


        consolidate();

        //find new max
        FibonacciNode<T> node = (FibonacciNode<T>) roots.getStart();
        for (int i = 0; i < roots.getSize(); i++) {
            if(node.getKey() > max.getKey()) {
                max = node;
            }
            node = (FibonacciNode<T>) node.getNext();
        }

        return tempMax;
    }

    public void decreaseKey(FibonacciNode<T> node, int key) {

    }

    private void consolidate() {
        /*
        int arraySize = roots.getSize();
        FibonacciNode<T>[] nodeArray = new FibonacciNode[arraySize];
        DynamicArray<FibonacciNode<T>> rootArray = new DynamicArray<>(roots);

        for (int i = 0; i < rootArray.size(); i++) {
            if(nodeArray[rootArray.get(i).getDegree()] == null) {
                nodeArray[rootArray.get(i).getDegree()] = rootArray.get(i);
            }
        }
        */

        int arraySize = getSize();
        FibonacciNode<T>[] nodeArray = new FibonacciNode[arraySize];

        FibonacciNode<T> node = (FibonacciNode<T>) roots.getStart();
        max = node; //set to start node because original max was removed

        int degree, count = 0;

        //Traverse roots
        while (roots.getSize() != count) {
            degree = node.getDegree();

            if(nodeArray[degree] != null) {                             //if node with matching degree
                //maintain heap property
                if(nodeArray[degree].getKey() > node.getKey()) {
                    roots.remove(node);
                    nodeArray[degree].getChildren().append(node);
                    node = nodeArray[degree];
                    nodeArray[degree] = null;
                }
                else {
                    roots.remove(nodeArray[degree]);
                    node.getChildren().append(nodeArray[degree]);
                    nodeArray[degree] = null;
                }

                count--;

            }
            else {
                nodeArray[degree] = node;
                node = (FibonacciNode<T>) node.getNext();
                count++;
            }
        }
    }

    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    //getters and setters
    public FibonacciNode<T> getMax() { return max; }
    private void setMax(FibonacciNode<T> max) { this.max = max; }
    public int getSize() { return size; }

    @Override
    public String toString() {
        return roots.toString();
    }
}
