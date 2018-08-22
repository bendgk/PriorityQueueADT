package com.benjamin;

public class Main {

    public static void main(String[] args) {
        //testing DynamicArray
        DynamicArray<Integer> arr = new DynamicArray<>();
        for (int i = 0; i < 10; i++) {
            arr.insert(i);
        }

        arr.pop(2);
        System.out.println(arr);
    }
}
