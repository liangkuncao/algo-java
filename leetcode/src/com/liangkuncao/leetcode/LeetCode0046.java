package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode0046 {
    /**
     * 解法：回溯
     * 时间复杂度：O（N*N！）
     * 空间复杂度：O（N）
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            cur.add(num);
        }
        backtrack(result,0, cur);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int index, List<Integer> cur) {
        if (index == cur.size()) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < cur.size(); i++) {
            Collections.swap(cur, index, i);
            backtrack(result, index + 1, cur);
            Collections.swap(cur, index, i);
        }
    }
}
