package com.example;

import java.util.Arrays;

public class ZeroToEnd {

    public static void main(String[] args) {
        int [] arr1 = new int[]{1, 0, 2, 3, 0, 1};
        int [] arr2 = new int[]{0, 1, 2, 3, 0, 1};

        zeroToEnd(arr1);
        zeroToEnd(arr2);

        Arrays.stream(arr1).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Arrays.stream(arr2).forEach(n -> System.out.print(n + " "));
    }

    private static void zeroToEnd(int[] arr) {
        int l = 0;

        for (int r = 0; r < arr.length; r++) {
            if(arr[r] != 0) {
                swap(arr, l, r);
                l++;
            }
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
