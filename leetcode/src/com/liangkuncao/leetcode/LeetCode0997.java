package com.liangkuncao.leetcode;

public class LeetCode0997 {
    /**
     * 题型：数组
     * 题解：图
     * 时间复杂度：O（n+m)
     * 空间复杂度：O（n)
     * @param n
     * @param trust
     * @return
     */
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        for (int[] t : trust) {
            inDegree[t[1]]++;
            outDegree[t[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
