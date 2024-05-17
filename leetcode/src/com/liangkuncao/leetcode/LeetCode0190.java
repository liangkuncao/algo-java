package com.liangkuncao.leetcode;

public class LeetCode0190 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            int bit = n & 1;
            result |= bit << (31 - i);
            n >>>= 1;
        }
        return result;
    }
}
