package com.liangkuncao.leetcode;

public class LeetCode0209 {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int resultLen = Integer.MAX_VALUE;
        int curSum = nums[0];
        while (true) {
            if (curSum < target) {
                end++;
                if (end >= nums.length) {
                    break;
                }
                curSum += nums[end];
            } else {
                resultLen = Math.min(resultLen, end - start + 1);
                curSum -= nums[start];
                start++;
            }
        }
        return resultLen == Integer.MAX_VALUE ? 0 : resultLen;

    }

    public static void main(String[] args) {
        LeetCode0209 leetCode0209 = new LeetCode0209();
        int result = leetCode0209.minSubArrayLen(7, new int[] {2,3,1,2,4,3});
        assert result == 2;
    }
}
