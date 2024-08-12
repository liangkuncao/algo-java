package com.liangkuncao.leetcode;

public class LeetCode0338 {

    /**
     * 题解：位运算n & (n - 1)
     * 时间复杂度：O(N logN)
     * 空间复杂度：O（1）
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = countOnes(result, i);
        }
        return result;
    }

    private int countOnes(int[] result, int i) {
        int count = 0;
        while (i > 0) {
            if (result[i] != 0) {
                count += result[i];
                break;
            }
            i &= i - 1;
            count++;
        }
        return count;
    }

    /**
     * 解法：
     *
     * @param n
     * @return
     */
    public int[] countBits2(int n) {
        int[] counts = new int[n + 1];
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i & (i - 1)] + 1;
        }
        return counts;
    }

    /**
     * 题解：动态规划
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param n
     * @return
     */
    public int[] countBits3(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i & (n - 1)] + 1;
        }
        return dp;
    }
}