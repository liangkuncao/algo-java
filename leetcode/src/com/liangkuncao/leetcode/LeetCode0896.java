package com.liangkuncao.leetcode;

public class LeetCode0896 {
    public boolean isMonotonic(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int increaseCount = 0;
        int decreaseCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] < nums[i - 1]) {
                decreaseCount++;
            } else {
                increaseCount++;
            }
            if (increaseCount > 0 && decreaseCount > 0) {
                return false;
            }
        }
        return true;
    }
}
