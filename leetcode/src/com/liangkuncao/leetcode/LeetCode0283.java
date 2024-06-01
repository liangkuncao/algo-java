package com.liangkuncao.leetcode;

public class LeetCode0283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int left = 0;
        int right = 1;
        while (left < nums.length && right < nums.length) {
            if (left == right || nums[right] == 0) {
                right++;
                continue;
            }
            if (nums[left] == 0) {
                nums[left] = nums[right];
                nums[right] = 0;
            }
            left++;
        }
    }
}
