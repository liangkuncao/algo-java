package com.liangkuncao.leetcode;

public class LeetCode0300 {
    /**
     * 题解：动态规划
     * 时间复杂度：O（N*N）
     * 空间复杂度：O（N）
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     * 题解：二分+贪心
     * 时间复杂度：O（N logN)
     * 空间复杂度：O（N）
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] incList = new int[nums.length];
        incList[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > incList[len - 1]) {
                incList[len] = nums[i];
                len++;
            } else {
                int left = 0;
                int right = len - 1;
                int pos = -1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (incList[mid] < nums[i]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                incList[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LeetCode0300 leetCode0300 = new LeetCode0300();
        int[] nums = new int[] {0,1,0,3,2,3};
        leetCode0300.lengthOfLIS2(nums);
    }
}
