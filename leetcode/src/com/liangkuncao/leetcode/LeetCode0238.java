package com.liangkuncao.leetcode;

/**
 * 题型：数组
 * 解法：两次遍历数组，空间复杂度o(1),时间复杂度o(n)
 */
public class LeetCode0238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        result[0] = prefix;
        for (int i = 1; i < nums.length; i++) {
            prefix *= nums[i - 1];
            result[i] = prefix;
        }
        int suffix = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix *= nums[i + 1];
            result[i] *= suffix;
        }
        return result;
    }
}
