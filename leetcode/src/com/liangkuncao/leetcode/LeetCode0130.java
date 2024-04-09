package com.liangkuncao.leetcode;

public class LeetCode0130 {
    private static final char TEMP = 'T';
    private static final char LAND = 'O';
    private static final char WATER = 'X';

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int x = 0; x < m; x++) {
            dfs(board, x, 0);
            dfs(board, x, n - 1);
        }
        for (int y = 0; y < n; y++) {
            dfs(board, 0, y);
            dfs(board, m - 1, y);
        }
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == LAND) {
                    board[x][y] = WATER;
                } else if (board[x][y] == TEMP) {
                    board[x][y] = LAND;
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (board[x][y] != LAND) {
            return;
        }
        board[x][y] = TEMP;
        dfs(board, x, y - 1);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x + 1, y);
    }
}
