package com.liangkuncao.leetcode;

public class LeetCode0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int start = 0;
        int total = 0;
        int curTotal = 0;
        for (int i = 0; i < length; i++) {
            total += gas[i] - cost[i];
            curTotal += gas[i] - cost[i];
            if (curTotal < 0) {
                start = i + 1;
                curTotal = 0;
            }
        }
        return total < 0 ? -1 : start;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int length = gas.length;
        int start = 0;
        while (start < length) {
            int cnt = 0;
            int total = 0;
            while (cnt < length) {
                int cur = (start + cnt) % length;
                total += gas[cur] - cost[cur];
                if (total < 0) {
                    break;
                }
                cnt++;
            }
            if (cnt == length) {
                return start;
            }
            start += cnt + 1;
        }
        return -1;
    }
}