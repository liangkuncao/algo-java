package com.liangkuncao.leetcode;

public class LeetCode0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] row = getRow(matrix, target);
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private int[] getRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int row = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] <= target) {
                row = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return matrix[row];
    }

    /**
     * 解法：二分
     * 时间复杂度：O（logMN）
     * 空间复杂度：O（1）
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = matrix[mid / n][mid % n];
            if (value < target) {
                left = mid + 1;
            } else if (value > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}