package com.liangkuncao.leetcode;

public class LeetCode12232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0];
        int deltaY = coordinates[0][1];
        for (int i = 1; i < coordinates.length; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
            if (i == 1) {
                continue;
            }
            int[] previousDot = coordinates[i - 1];
            int[] currentDot = coordinates[i];
            if (previousDot[0] * currentDot[1] != previousDot[1] * currentDot[0]) {
                return false;
            }
        }
        return true;
    }
}
