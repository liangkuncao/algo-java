package com.liangkuncao.leetcode;

public class LeetCode1791 {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] labelDegrees = new int[n + 1];
        for (int[] edge : edges) {
            labelDegrees[edge[0]]++;
            labelDegrees[edge[1]]++;
        }
        for (int i = 1; i <= labelDegrees.length; i++) {
            if (labelDegrees[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
