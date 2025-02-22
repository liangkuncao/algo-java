package com.liangkuncao.leetcode;

public class LeetCode0709 {
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();
        int diff = 'A' - 'a';
        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch < 'Z') {
                result.append((char) (ch - diff));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
