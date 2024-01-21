package com.liangkuncao.leetcode;

import java.util.Arrays;

public class LeetCode0541 {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int start = 0; start < n; start += 2 * k) {
            int end = Math.min(start + k, n) - 1;
            reverseCharArray(chars, start, end);
        }
        return new String(chars);
    }

    private void reverseCharArray(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
