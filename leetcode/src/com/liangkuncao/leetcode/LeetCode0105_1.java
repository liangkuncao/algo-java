package com.liangkuncao.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode0105_1 {
    int[][] directions = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(grid, i, j));
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return 0;
        }
        if (y < 0 || y >= grid[0].length) {
            return 0;
        }
        if (grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 2;
        int result = 1;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            result += dfs(grid, newX, newY);

        }
        return result;
    }

    public int maxAreaOfIslandStack(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = dfsStack(grid, i, j);
                result = Math.max(result, cur);
            }
        }
        return result;
    }

    private int dfsStack(int[][] grid, int i, int j) {
        int cur = 0;
        Deque<int[]> stack = new LinkedList<>();
        stack.add(new int[]{i, j});
        while (!stack.isEmpty()) {
            int[] position = stack.pop();
            int x = position[0];
            int y = position[1];
            if (x < 0 || x >= grid.length) {
                continue;
            }
            if (y < 0 || y >= grid[0].length) {
                continue;
            }
            if (grid[x][y] != 1) {
                continue;
            }
            cur++;
            grid[x][y] = 2;
            for (int[] direction : directions) {
                int[] newPosition = new int[] {x + direction[0], y + direction[1]};
                stack.add(newPosition);
            }
        }
        return cur;
    }
}