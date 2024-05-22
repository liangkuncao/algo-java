package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

public class LeetCode0105 {
    int[][] directions = new int[][] {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = count(grid, i, j);
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }

    private int count(int[][] grid, int x, int y) {
        if (grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 2;
        int result = 1;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX < 0 || newX >= grid.length) {
                continue;
            }
            if (newY < 0 || newY >= grid[0].length) {
                continue;
            }
            if (grid[newX][newY] == 1) {
                result += count(grid, newX, newY);
            }
        }
        return result;
    }
}