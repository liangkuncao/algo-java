package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        dfs(nums, new int[k], 0, k);
        return null;
    }

    private void dfs(int[] nums, int[] ints, int i, int k) {
        
    }
}
