package com.benjamin;

public class Main {

    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<Integer>();
        for (int i = 0; i < 10; i++) {
            arr.insert(i);
        }

        arr.pop(2);
        System.out.println(arr);
    }
}
