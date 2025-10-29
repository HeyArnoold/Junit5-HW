package com.example.search;

import java.util.Arrays;

public class SearchLinearAndBinary {

    public static void main(String[] args) {
        int[] array = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};

        searchLinear(array, 16);

        Arrays.sort(array);
        searchBinary(array, 0, array.length - 1, 16);
    }

    private static int searchLinear(int[] array, int elementToFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementToFind) {
                System.out.println("found at index: " + i + ", value: " + array[i]);
                return i;
            }
        }
        System.out.println("not found: " + elementToFind);
        return -1;
    }

    /**
     * Работает только с отсортированным массивом
     */
    private static int searchBinary(int[] array, int startIndex, int endIndex, int elementToFind) {
        if (endIndex >= startIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (array[middleIndex] == elementToFind) {
                System.out.println("found at index: " + middleIndex + ", value: " + array[middleIndex]);
                return middleIndex;
            }

            if (array[middleIndex] > elementToFind) {
                return searchBinary(array, startIndex, middleIndex - 1, elementToFind);
            } else {
                return searchBinary(array, middleIndex + 1, endIndex, elementToFind);
            }
        }

        System.out.println("not found: " + elementToFind);
        return -1;
    }

}
