package com.liangkuncao.leetcode;

public class LeetCode0136 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }
}
