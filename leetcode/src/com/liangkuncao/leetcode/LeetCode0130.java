package com.liangkuncao.leetcode;

public class LeetCode0130 {
    private final char tmp = '1';
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int x = 0; x < m; x++) {
            if (board[x][0] == 'O') {
                changeValue(board, x, 0);
            }
            if (board[x][n - 1] == 'O') {
                changeValue(board, x, n - 1);
            }
        }
        for (int y = 0; y < n; y++) {
            if (board[0][y] == 'O') {
                changeValue(board, 0, y);
            }
            if (board[m - 1][y] == 'O') {
                changeValue(board, m - 1, y);
            }
        }
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 'O') {
                    board[x][y] = 'X';
                } else if (board[x][y] == tmp) {
                    board[x][y] = 'O';
                }
            }
        }
    }

    private void changeValue(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (board[x][y] != 'O') {
            return;
        }
        board[x][y] = tmp;
        changeValue(board, x, y - 1);
        changeValue(board, x - 1, y);
        changeValue(board, x, y + 1);
        changeValue(board, x + 1, y);
    }
}
