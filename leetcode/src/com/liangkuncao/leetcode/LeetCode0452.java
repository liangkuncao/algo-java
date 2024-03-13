package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode0452 {
    /**
     * 题型：区间interval
     * 解法：模拟+贪心+排序
     * 时间复杂度：O（NlogN)
     * 空间复杂度：O（NlogN)
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] point : points) {
            int lastIndex = result.size() - 1;
            if (result.isEmpty() || point[0] > result.get(lastIndex)[1]) {
                result.add(point);
            } else {
                result.get(lastIndex)[0] = Math.max(result.get(lastIndex)[0], point[0]);
                result.get(lastIndex)[1] = Math.min(result.get(lastIndex)[1], point[1]);
            }
        }
        return result.size();
    }

    public int findMinArrowShots2(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        int pos = points[0][1];
        int result = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                result++;
            }
        }
        return result;
    }
}
