package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0338 {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int help = 2;
        for (int i = 0; i < result.length; i++) {
            result[i] = countOnes(i);
        }
        return result;
    }

    private int countOnes(int i) {
        int count = 0;
        while (i > 0) {
            i &= i - 1;
            count++;
        }
        return count;
    }
}