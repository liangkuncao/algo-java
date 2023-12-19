package com.liangkuncao.leetcode;

public class LeetCode0191 {
    /**
     * 时间复杂度：O（log N）
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
