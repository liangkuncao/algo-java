package com.liangkuncao.leetcode;

import java.util.Arrays;

public class LeetCode0016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if (total == target) {
                    return target;
                }
                if (Math.abs(total - target) < Math.abs(best - target)) {
                    best = total;
                }
                if (total < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return best;
    }
}
