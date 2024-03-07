package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode0289 {
    public void gameOfLife(int[][] board) {
        List<int[]> births = new ArrayList<>();
        List<int[]> deaths = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        List<int[]> adjList = getAdjOffsets();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;
                for (int[] adj : adjList) {
                    int nextRow = i + adj[0];
                    int nextCol = j + adj[1];
                    if (nextRow >= 0 && nextRow < m
                            && nextCol >= 0 && nextCol < n
                            && board[nextRow][nextCol] == 1) {
                        liveCount++;
                    }
                }
                if (board[i][j] == 0 && liveCount == 3) {
                    births.add(new int[] {i, j});
                }
                if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                    deaths.add(new int[] {i, j});
                }
            }
        }
        for (int[] birth : births) {
            board[birth[0]][birth[1]] = 1;
        }
        for (int[] death : deaths) {
            board[death[0]][death[1]] = 0;
        }
    }

    private static List<int[]> getAdjOffsets() {
        List<int[]> adj = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                adj.add(new int[] {i, j});
            }
        }
        return adj;
    }


    public void gameOfLife2(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        List<int[]> adjList = getAdjOffsets();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                for (int[] adj : adjList) {
                    int nextRow = i + adj[0];
                    int nextCol = j + adj[1];
                    if ((nextRow >= 0 && nextRow < m)
                            && (nextCol >= 0 && nextCol < n)
                            && Math.abs(board[nextRow][nextCol]) == 1) {
                        liveNeighbors++;
                    }
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}
