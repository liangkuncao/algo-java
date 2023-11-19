package com.liangkuncao.leetcode;

public class LeetCode0028 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            boolean found = true;
            for (int j = 0; j < needle.length(); j++) {
                char haystackChar = haystack.charAt(i + j);
                char needleChar = needle.charAt(j);
                if (needleChar != haystackChar) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
