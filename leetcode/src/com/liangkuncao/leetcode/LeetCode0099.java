package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0099 {
    public int snakesAndLadders(int[][] board) {
        int end = board.length * board.length;
        List<Integer> curPositions = new ArrayList<>();
        boolean[] visited = new boolean[end + 1];
        curPositions.add(1);
        int result = 0;
        while (true) {
            result++;
            List<Integer> nextPositions = new ArrayList<>();
            for (int curPosition : curPositions) {
                visited[curPosition] = true;
                for (int i = 1; i <= 6; i++) {
                    int nextPosition = curPosition + i;
                    if (nextPosition > end) {
                        break;
                    }
                    nextPosition = getFinalPosition(board, nextPosition);
                    if (nextPosition == end) {
                        return result;
                    }
                    if (!visited[nextPosition]) {
                        nextPositions.add(nextPosition);
                    }
                }
            }
            if (nextPositions.isEmpty()) {
                break;
            }
            curPositions = nextPositions;
        }
        return -1;
    }

    private int getFinalPosition(int[][] board, int id) {
        int n = board.length;
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        if (board[n - 1 - r][c] > 0) {
            return board[n - 1 - r][c];
        }
        return id;
    }
}
