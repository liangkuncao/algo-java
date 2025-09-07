package com.liangkuncao.leetcode;

public class LeetCode0034 {
    /**
     * 超时
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange_timeout(int[] nums, int target) {
        int[] defaultResult = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return defaultResult;
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return defaultResult;
        }
        int left = 0;
        int right = nums.length - 1;
        int targetIdx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                targetIdx = mid;
            }
        }
        if (targetIdx == -1) {
            return defaultResult;
        }
        int low = targetIdx;
        while (low - 1 >= 0 && nums[low - 1] == target) {
            low--;
        }
        int high = targetIdx;
        while (high + 1 <= nums.length - 1 && nums[high + 1] == target) {
            high++;
        }
        return new int[]{low, high};
    }

    public int[] searchRange(int[] nums, int target) {
        int[] defaultResult = new int[] {-1, -1};
        if (nums == null || nums.length == 0) {
            return defaultResult;
        }
        int n = nums.length;
        if (target < nums[0] || nums[n - 1] < target) {
            return defaultResult;
        }
        int left = 0;
        int right = n - 1;
        int leftBorder = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
                leftBorder = right;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = n - 1;
        int rightBorder = left;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
                rightBorder = left;
            } else {
                right = mid - 1;
            }
        }
        if (rightBorder - leftBorder == 1) {
            return defaultResult;
        }
        return new int[] {leftBorder + 1, rightBorder - 1};
    }
}