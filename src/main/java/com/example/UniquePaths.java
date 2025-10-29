package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
Условие:
Дана прямоугольная доска размером N × M (N строк, M столбцов).
В левом верхнем углу (0, 0) находится робот.
Он может двигаться только двумя способами:

На 1 клетку вниз → (i+1, j)
На 1 клетку вправо → (i, j+1)
Цель:
Попасть в правый нижний угол (N-1, M-1).

Вопрос:
Сколько существует различных маршрутов из (0, 0) в (N-1, M-1)?

Ограничения:
1 ≤ N, M ≤ 50

Пример:
Ввод: N = 3, M = 2
Вывод: 3
(Пути: ВВП, ВПВ, ПВВ — где В = вниз, П = вправо)
 */
public class UniquePaths {

    public static void main(String[] args) throws IOException {
        System.out.println(uniquePaths(10, 10));
    }

    static private int uniquePaths(int n, int m) {
        return uniquePathsHelper(n, m, new int[n][m]);
    }

    static private int uniquePathsHelper(int n, int m, int[][] arr) {
        if (n == 1 && m == 1) {
            return 1;
        }

        if (n < 1 || m < 1) {
            return 0;
        }

        if (arr[n - 1][m - 1] != 0) {
            return arr[n][m];
        }

        return uniquePathsHelper(n - 1, m, arr) + uniquePathsHelper(n, m - 1, arr);
    }
}
