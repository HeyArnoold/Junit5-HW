package com.example;

import java.math.BigInteger;
import java.util.Arrays;

public class FiboNums {

    public static void main(String[] args) {
        System.out.println(fibWithArray(100));
        System.out.println(fibWithoutArray(100));

        int num = 100;
        long[] array = new long[num + 1];
        Arrays.fill(array, -1);
        System.out.println(fibRecursiveWithMemo(num, array));

        System.out.println(fibRecursive(100));
    }


    private static long fibRecursive(int n) {
        if(n <= 1) {
            return n;
        }

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    private static long fibRecursiveWithMemo(int n, long[] array) {
        if (array[n] != -1) {
            return array[n];
        }

        if(n <= 1) {
            return n;
        }

        long result = fibRecursiveWithMemo(n - 1, array) + fibRecursiveWithMemo(n - 2, array);
        array[n] = result;
        return result;
    }

    private static long fibWithArray(int n) {

        if (n <= 1) {
            return n;
        }

        long[] arr = new long[n + 1];

        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        return arr[n];
    }

    public static BigInteger fibWithoutArray(int n) {

        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger prev1 = BigInteger.ZERO;
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger sum = prev1.add(result);
            prev1 = result;
            result = sum;
        }

        return result;
    }
}
