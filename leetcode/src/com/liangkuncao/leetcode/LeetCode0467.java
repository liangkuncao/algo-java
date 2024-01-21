package com.liangkuncao.leetcode;

import java.util.Arrays;

public class LeetCode0467 {
    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1) {
                count++;
            } else {
                count = 1;
            }
            dp[s.charAt(i) - 'a'] = Math.max(dp[s.charAt(i) - 'a'], count);
        }return Arrays.stream(dp).sum();
    }

}
