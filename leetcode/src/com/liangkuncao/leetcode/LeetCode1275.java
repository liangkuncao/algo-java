package com.liangkuncao.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1275 {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            if (i % 2 == 0) {
                board[x][y] = 1;
            } else {
                board[x][y] = -1;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(row(board, i));
            set.add(col(board, i));
        }
        set.add(board[0][2] + board[1][1] + board[2][0]);
        set.add(board[0][0] + board[1][1] + board[2][2]);
        if (set.contains(3)) {
            return "A";
        } else if (set.contains(-3)) {
            return "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    private Integer col(int[][] board, int c) {
        return board[0][c] + board[1][c] + board[2][c];
    }

    private Integer row(int[][] board, int r) {
        return board[r][0] + board[r][1] + board[r][2];
    }
}
