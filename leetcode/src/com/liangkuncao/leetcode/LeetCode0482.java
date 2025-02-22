package com.liangkuncao.leetcode;

public class LeetCode0482 {
    public String licenseKeyFormatting(String s, int k) {
        int len = s.length();
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                continue;
            }
            if (count == k) {
                result.append('-');
                count = 0;
            }
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) ('A' + ch - 'a');
            }
            result.append(ch);
            count++;
        }
        return result.reverse().toString();
    }
}
