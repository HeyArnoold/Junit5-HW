package com.example;

import java.util.HashMap;
import java.util.Map;

public class FindMaxChar {

    public static void main(String[] args) {
        System.out.println(findMaxChar("abababaads"));
    }

    private static String findMaxChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        String ans = "";
        int ansCount = 0;
        char[] chars = s.toCharArray();

        for (char now : chars) {
            if (!map.containsKey(now)) {
                map.put(now, 0);
            }
            map.put(now, map.get(now) + 1);
        }

        for (Character c : map.keySet()) {
            if (map.get(c) > ansCount) {
               ansCount = map.get(c);
               ans = c.toString();
            }
        }
        return ans;
    }
}
