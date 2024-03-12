package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansList = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean isPlaced = false;
        for (int[] interval : intervals) {
            if (right < interval[0]) {
                if (!isPlaced) {
                    ansList.add(new int[]{left, right});
                    isPlaced = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                ansList.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!isPlaced) {
            ansList.add(new int[] {left, right});
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}
