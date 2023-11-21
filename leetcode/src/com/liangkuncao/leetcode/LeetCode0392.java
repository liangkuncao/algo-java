package com.liangkuncao.leetcode;

public class LeetCode0392 {
    public boolean isSubsequence(String s, String t) {
        for (int p1 = 0, p2 = 0; p1 < s.length(); p1++, p2++) {
            while (p2 < t.length() && t.charAt(p2) != s.charAt(p1)) {
                p2++;
            }
            if (p2 == t.length()) {
                return false;
            }
        }
        return true;
    }
}
