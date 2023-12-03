package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                int end = i - 1;
                if (start == end) {
                    result.add(String.valueOf(nums[start]));
                } else {
                    result.add(nums[start] + "->" + nums[end]);
                }
                start = i;
            }
        }
        return result;
    }
}

