package com.liangkuncao.leetcode;

import java.util.Arrays;

public class LeetCode0274 {
    /**
     * 题型：数组
     * 解法：遍历
     * 时间复杂度：O（NLogN）
     * 空间复杂度：O（LogN）
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations); // 时间复杂度是NlogN
        int hIndex = 0;
        int i = citations.length - 1;
        while (i >= 0 && citations[i] > hIndex) {
            hIndex++;
            i--;
        }
        return hIndex;
    }

    /**
     *
     * @param citations
     * @return
     */
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }
        int total = 0;
        int hIndex = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total > i) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 未AC
     * @param citations
     * @return
     */
    public int hIndex3(int[] citations) {
        int left = 0;
        int right = citations.length;
        int mid = 0;
        int cnt = 0;
        while (left < right) {
            mid = (left + right) / 2;
            cnt = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= mid) {
                    cnt++;
                }
            }
            if (cnt == mid) {
                return mid;
            } else if (cnt > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        LeetCode0274 leetCode0274 = new LeetCode0274();
        int result = leetCode0274.hIndex(new int[] {1,3,1});
    }
}
