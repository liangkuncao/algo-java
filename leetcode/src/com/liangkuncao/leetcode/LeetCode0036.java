package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode0036 {
    private static final int ROW = 9;
    private static final int COL = 9;
    public boolean isValidSudoku(char[][] board) {
        return isRowValid(board) && isColumnValid(board) && isSubSquareValid(board);
    }

    private boolean isSubSquareValid(char[][] board) {
        int[] x = new int[] {0, 3, 6};
        List<int[]> points = new ArrayList<>();
        for (int i : x) {
            for (int j : x) {
                points.add(new int[] {i, j});
            }
        }
        int[] y = new int[] {0, 1, 2};
        List<int[]> addList = new ArrayList<>();
        for (int i : y) {
            for (int j : y) {
                addList.add(new int[] {i, j});
            }
        }
        for (int[] point : points) {
            Set<Character> set = new HashSet<>();
            for (int[] add : addList) {
                int r = point[0] + add[0];
                int c = point[1] + add[1];
                if (board[r][c] == '.') {
                    continue;
                }
                if (set.contains(board[r][c])) {
                    return false;
                }
                set.add(board[r][c]);
            }
        }
        return true;
    }

    private boolean isColumnValid(char[][] board) {
        for (int c = 0; c < COL; c++) {
            Set<Character> set = new HashSet<>();
            for (int r = 0; r < ROW; r++) {
                if (board[r][c] == '.') {
                    continue;
                }
                if (set.contains(board[r][c])) {
                    return false;
                }
                set.add(board[r][c]);
            }
        }
        return true;
    }

    private boolean isRowValid(char[][] board) {
        for (int r = 0; r < ROW; r++) {
            Set<Character> set = new HashSet<>();
            for (int c = 0; c < COL; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                if (set.contains(board[r][c])) {
                    return false;
                }
                set.add(board[r][c]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] initialArray = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        LeetCode0036 leetCode0036 = new LeetCode0036();
        boolean result = leetCode0036.isValidSudoku(initialArray);
        System.out.println(result);
    }
}
