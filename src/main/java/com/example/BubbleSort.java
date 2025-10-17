package com.example;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{14, 12, 11, 12, 13, 14, 15, 16};

        print(array);

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
            print(array);
        }


//        print(array);
    }

    static void print(int[] array) {
        StringBuilder s = new StringBuilder();
        for (int i : array) {
            s.append(i);
            s.append(" ");
        }
        System.out.println(s);
    }
}
