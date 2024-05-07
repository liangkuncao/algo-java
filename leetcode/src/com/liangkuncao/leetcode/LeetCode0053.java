package com.liangkuncao.leetcode;

public class LeetCode0053 {
    public int maxSubArray(int[] nums) {
        int result = -1_000_000;
        int curMax = -1_000_000;
        for (int num : nums) {
            curMax = Math.max(num, num + curMax);
            result = Math.max(curMax, result);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode0053 leetCode0053 = new LeetCode0053();
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int result = leetCode0053.maxSubArray(nums);
        System.out.println(result);
    }
}
