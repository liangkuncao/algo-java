package com.liangkuncao.leetcode;

import java.util.Arrays;

public class LeetCode0274 {
    /**
     * 题型：数组
     * 解法：遍历
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations); // 时间复杂度是NlogN
        int result = 0;
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            count++;
            if (citations[i] >= count) {
                result = count;
            } else {
                break;
            }
        }
        return result;
    }
}
