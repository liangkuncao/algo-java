package com.liangkuncao.leetcode;

public class LeetCode0070 {
    int[] steps = null;
    public int climbStairs(int n) {
        int p = 0, q = 0, res = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = res;
            res = p + q;
        }
        return res;
    }

    /**
     * 解法：使用记忆和递归
     * 时间复杂度：O（N）
     * 空间复杂度：0（N）
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (steps == null) {
            steps = new int[n + 1];
        }
        if (steps[n] != 0) {
            return steps[n];
        }
        int count;
        if (n == 0) {
            count = 1;
        } else if (n == 1) {
            count = 1;
        } else {
            count = climbStairs2(n - 1) + climbStairs2(n - 2);
        }
        steps[n] = count;
        return count;
    }

    /**
     * 解法：动态规划，一般走楼梯涉及状态变化，都是动态规划题目
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        int first = 1;
        int second = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    /**
     * time complexity：O(N)
     * space complexity: O(N)
     * @param n
     * @return
     */
    public int climbStairs4(int n) {
        int[] steps = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i == 0 || i == 1) {
                steps[i] = 1;
                continue;
            }
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }
}
