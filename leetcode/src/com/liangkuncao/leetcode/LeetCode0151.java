package com.liangkuncao.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class LeetCode0151 {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            }
            if ((i == 0 || s.charAt(i - 1) == ' ') && count > 0) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(s, i, i + count);
                count = 0;
            }
        }
        return result.toString();
    }

    public String reverseWords2(String s) {
        s = s.trim();
        List<String> split = Arrays.asList(s.split("\\s+"));
        Collections.reverse(split);
        return String.join(" ", split);
    }

    public String reverseWords3(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            if (s.charAt(left) != ' ') {
                word.append(s.charAt(left));
            } else if (s.charAt(left) == ' ' && s.charAt(left - 1) != ' ') {
                deque.offerFirst(word.toString());
                word.setLength(0);
            }
            left++;
        }
        return String.join(" ", deque);
    }
}
