package com.liangkuncao.leetcode;

public class LeetCode0055 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxPosition = 0;
        for (int i = 0; i < n; i++) {
            if (maxPosition < i) {
                return false;
            }
            if (maxPosition >= n - 1) {
                return true;
            }
            maxPosition = Math.max(maxPosition, i + nums[i]);
        }
        return true;
    }
}
