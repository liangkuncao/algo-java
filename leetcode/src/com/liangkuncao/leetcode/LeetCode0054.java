package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0054 {
    private final static int MARK = 1000;

    /**
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] x = new int[] {0, 1, 0, -1};
        int[] y = new int[] {1, 0, -1, 0};
        int direction = 0;
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = m * n;
        int[] cur = new int[] {0, -1};
        while (cnt > 0) {
            int newX = cur[0] + x[direction];
            int newY = cur[1] + y[direction];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || matrix[newX][newY] == MARK) {
                direction = (direction + 1) % 4;
            }
            cur[0] += x[direction];
            cur[1] += y[direction];
            result.add(matrix[cur[0]][cur[1]]);
            matrix[cur[0]][cur[1]] = MARK;
            cnt--;
        }
        return result;
    }
}
