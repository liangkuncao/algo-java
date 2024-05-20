package com.liangkuncao.leetcode;

public class LeetCode0172 {
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; i <= n; i += 5) {
            int cur = i;
            while (cur % 5 == 0) {
                cur /= 5;
                count++;
            }
        }
        return count;
    }
}
