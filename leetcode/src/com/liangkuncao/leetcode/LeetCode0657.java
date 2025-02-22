package com.liangkuncao.leetcode;

public class LeetCode0657 {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (Character move : moves.toCharArray()) {
            switch (move) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                default:
                    x++;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
