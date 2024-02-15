package com.liangkuncao.leetcode;

public class LeetCode0011 {
    /**
     * 题型：数组，二维数组，面积
     * 解法：双指针
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            result = Math.max(result,
                    (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
