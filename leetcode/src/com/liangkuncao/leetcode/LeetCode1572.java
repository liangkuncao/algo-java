package com.liangkuncao.leetcode;

public class LeetCode1572 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int colPrimary = 0;
        int colSecondary = n - 1;
        int total = 0;
        for (int[] row : mat) {
            total += row[colPrimary];
            if (colSecondary != colPrimary) {
                total += row[colSecondary];
            }
            colPrimary++;
            colSecondary--;
        }
        return total;
    }
}
