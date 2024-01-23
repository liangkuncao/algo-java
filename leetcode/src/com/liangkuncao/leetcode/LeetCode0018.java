package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < n - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < n - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = second + 1;
                int forth = n - 1;
                while (third < forth) {
                    long total = (long) nums[first] + nums[second] + nums[third] + nums[forth];
                    if (total == target) {
                        result.add(Arrays.asList(nums[first], nums[second], nums[third], nums[forth]));
                        while (third < forth && nums[third] == nums[third + 1]) {
                            third++;
                        }
                        third++;
                        while (forth > third && nums[forth] == nums[forth - 1]) {
                            forth--;
                        }
                        forth--;
                    } else if (total < target) {
                        third++;
                    } else {
                        forth--;
                    }
                }
            }
        }
        return result;
    }
}
