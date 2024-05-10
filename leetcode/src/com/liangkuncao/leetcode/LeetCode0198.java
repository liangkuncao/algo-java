package com.liangkuncao.leetcode;

public class LeetCode0198 {
    /**
     * 题型：动态数组
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int rob = nums[0];
        int noRob = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = rob;
            rob = noRob + nums[i];
            noRob = Math.max(temp, noRob);
        }
        return Math.max(rob, noRob);
    }
}
