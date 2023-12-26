package com.liangkuncao.leetcode;

public class LeetCode0070 {
    public int climbStairs(int n) {
        int p = 0, q = 0, res = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = res;
            res = p + q;
        }
        return res;
    }


}
