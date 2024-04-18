package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode0099 {
    private static final int MAX_STEP = 6;

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

    public int snakesAndLadders2(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int nxt = p[0] + i;
                if (nxt > n * n) { // 超出边界
                    break;
                }
                int[] rc = id2rc(nxt, n); // 得到下一步的行列
                if (board[rc[0]][rc[1]] > 0) { // 存在蛇或梯子
                    nxt = board[rc[0]][rc[1]];
                }
                if (nxt == n * n) { // 到达终点
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    queue.offer(new int[]{nxt, p[1] + 1}); // 扩展新状态
                }
            }
        }
        return -1;
    }

    public int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }

}
