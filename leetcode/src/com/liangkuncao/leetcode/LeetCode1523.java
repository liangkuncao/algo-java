package com.liangkuncao.leetcode;

public class LeetCode1523 {
    public int countOdds(int low, int high) {
        int totalCount = high - low + 1;
        int halfCount = totalCount >> 1;
        if ((totalCount & 1) == 1) {
            int firstOdd = low & 1;
            return halfCount + firstOdd;
        }
        return halfCount;
    }
}
