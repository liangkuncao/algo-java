package com.liangkuncao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0013 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += map.get(s.charAt(i));
            if (i > 0 && map.get(s.charAt(i - 1)).compareTo(map.get(s.charAt(i))) < 0) {
                result -= 2 * map.get(s.charAt(i -1));
            }
        }
        return result;
    }
}
