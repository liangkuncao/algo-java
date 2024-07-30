package com.liangkuncao.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode0169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;
        int cnt = 0;
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) > cnt) {
                cnt = count.get(num);
                result = num;
            }
        }
        return result;
    }
}
