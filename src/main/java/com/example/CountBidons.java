package com.example;


import java.util.Arrays;

/*
1.
На конвейере поступают емкости с жидкостями неотрицательного объема (порядок поступления емкостей менять нельзя).
Дано неограниченное кол-во бидонов некоторого положительного объема куда нужно сливать эти жидкости.
Емкость нужно вылить целиком, то есть если в будущем бидоне недостаточно места, нужно взять следующий бидон

Дана последовательность емкостей и объем бидона, нужно определить сколько бидонов нужно, чтобы опустошить все емкости.

Пример:
Емкости: 1 3 2 2 4 10 8 4 2 5 3
Вместимость бидона: 12

2.
Модификация предыдущей задачи. Теперь бидонов не бесконечное кол-во, а ограниченное (больше нуля). Но у бидонов может быть любой объем
Определите минимальный возможный объем бидонов, так чтобы все емкости можно было в них разместить

Пример:
4 бидона
Емкости: 1 3 2 2 4 10 8 4 2 5 3
 */
public class CountBidons {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 2, 4, 10, 8, 4, 2, 5, 3};
        System.out.println(countBidons(arr, 12));
        System.out.println(minBidonCapacity(arr, 1));

        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(search(arr2, 12));
    }

    private static int countBidons(int[] containers, int embrace) {
        if (containers == null || containers.length == 0) return 0;
        int bins = 1; // если кол-во контейнеров не 0, то нужен будет точно минимум 1 бидон
        int currentLoad = 0;

        for (int volume : containers) {
            if (volume > embrace) {
                return -1;
            }
            if (currentLoad + volume <= embrace) {
                currentLoad += volume;
            } else {
                bins++;
                currentLoad = volume;
            }
        }
        return bins;
    }

    public static int minBidonCapacity(int[] containers, int k) {
        if (containers == null || containers.length == 0) return 0;
        if (k <= 0) return -1;

        // Левая граница — максимальная емкость
        int left = 0;
        long sum = 0;
        for (int v : containers) {
            if (v < 0) return -1;
            left = Math.max(left, v);
            sum += v;
        }
        // Правая граница — сумма всех объемов
        long right = sum;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countBidons(containers, (int) mid) > k) {
                left = (int) mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 1 2 3 4 5 6 7 8 9 10
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;


        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (nums[l] != target) {
            return -1;
        }

        return l;
    }
}
