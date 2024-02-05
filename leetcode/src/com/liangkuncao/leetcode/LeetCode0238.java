package com.liangkuncao.leetcode;

/**
 * 题型：数组
 * 解法：
 *  1. 暴力，时间复杂度O(N*N)，空间复杂度O(1)
 *  2. 全部想乘，然后除以本身，时间复杂度O(N)，空间复杂度O(1)
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
