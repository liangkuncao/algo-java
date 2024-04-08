package com.liangkuncao.leetcode;

public class LeetCode0200 {
    int[][] directions = new int[][] {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    public int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    grid[i][j] = '0';
                    flip(grid, i, j);
                }
            }
        }
        return result;
    }

    private void flip(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI < 0 || newI >= m) {
                continue;
            }
            if (newJ < 0 || newJ >= n) {
                continue;
            }
            if (grid[newI][newJ] == '1') {
                grid[newI][newJ] = '0';
                flip(grid, newI, newJ);
            }
        }
    }
}
