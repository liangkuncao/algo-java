package com.liangkuncao.leetcode;

public class LeetCode0459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int subStringLen = 1; subStringLen < n; subStringLen++) {
            if (n % subStringLen != 0) {
                continue;
            }
            String subString = s.substring(0, subStringLen);
            boolean flag = true;
            for (int startIdx = subStringLen; startIdx + subStringLen <= n; startIdx += subStringLen) {
                String nextSubString = s.substring(startIdx, startIdx + subStringLen);
                if (nextSubString.compareTo(subString) != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
