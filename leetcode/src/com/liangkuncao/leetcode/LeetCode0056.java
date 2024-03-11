package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode0056 {
    /**
     * 题型：数组
     * 解法：遍历、排序
     * 时间复杂度：O（NlogN)，排序需要的时间复杂度
     * 空间复杂度：O（logN),排序需要的空间复杂度
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(obj -> obj[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            int lastIndex = result.size() - 1;
            if (result.isEmpty() || result.get(lastIndex)[1] < interval[0]) {
                result.add(interval);
            } else {
                result.get(lastIndex)[1] = Math.max(result.get(lastIndex)[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
