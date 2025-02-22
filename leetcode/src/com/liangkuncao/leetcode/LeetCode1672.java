package com.liangkuncao.leetcode;

public class LeetCode1672 {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int cur = 0;
            for (int i : account) {
                cur += i;
            }
            max = Math.max(cur, max);
        }
        return max;
    }
}
