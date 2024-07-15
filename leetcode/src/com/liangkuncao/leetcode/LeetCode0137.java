package com.liangkuncao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) == 3) {
                count.remove(num);
            }
        }
        for (int key : count.keySet()) {
            return key;
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            int remainder = total % 3;
            result |= remainder << i;
        }
        return result;
    }
}
