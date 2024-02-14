package com.liangkuncao.leetcode;

public class LeetCode0167 {
    /**
     * 题型：数组，排序好的数组
     * 解法：双指针
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 题型：数组，排序好的数组
     * 解法：二分查找
     * 时间复杂度：O（Nlogn）
     * 空间复杂度：O（1）
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int index = findValue(numbers, i + 1, target - numbers[i]);
            if (index != -1) {
                return new int[] {i + 1, index + 1};
            }
        }
        return new int[] {-1, -1};
    }

    private int findValue(int[] numbers, int start, int target) {
        int end = numbers.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}