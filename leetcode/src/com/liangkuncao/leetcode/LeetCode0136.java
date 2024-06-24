package com.liangkuncao.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode0136 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }

    public int singleNumber_20240624(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
