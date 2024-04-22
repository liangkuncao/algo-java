package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode0017 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Integer, Character[]> map = new HashMap<>() {
            {
                put(2, new Character[]{'a', 'b', 'c'});
                put(3, new Character[]{'d', 'e', 'f'});
                put(4, new Character[]{'g', 'h', 'i'});
                put(5, new Character[]{'j', 'k', 'l'});
                put(6, new Character[]{'m', 'n', 'o'});
                put(7, new Character[]{'p', 'q', 'r', 's'});
                put(8, new Character[]{'t', 'u', 'v'});
                put(9, new Character[]{'w', 'x', 'y', 'z'});
            }
        };
        Deque<StringBuilder> result = new LinkedList<>();
        result.offer(new StringBuilder());
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            int size = result.size();
            for (int j = 0; j < size; j++) {
                StringBuilder stringBuilder = result.poll();
                for (int k = 1; k < map.get(digit).length; k++) {
                    StringBuilder newString = new StringBuilder(stringBuilder).append(map.get(digit)[k]);

                    result.offer(newString);
                }
                stringBuilder.append(map.get(digit)[0]);
                result.offer(stringBuilder);
            }
        }
        return result.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LeetCode0017 leetCode0017 = new LeetCode0017();
        List<String> result = leetCode0017.letterCombinations("23");
        System.out.println(result);
    }
}