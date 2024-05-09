package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        help(current, result, 1, n, k);
        return result;
    }

    private void help(List<Integer> current, List<List<Integer>> result, int start, int end, int k) {
        if (k <= 0) {
            result.add(List.copyOf(current));
            return;
        }
        for (int i = start; i <= end; i++) {
            current.add(i);
            help(current, result, i + 1, end, k - 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode0077 leetCode0077 = new LeetCode0077();
        leetCode0077.combine(4, 2);
    }

}
