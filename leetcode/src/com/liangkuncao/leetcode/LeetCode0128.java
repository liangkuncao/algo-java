package com.liangkuncao.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode0128 {
    /**
     * 题型：数组
     * 解法：哈希
     * 时间复杂度：O（N）
     * 空间复杂度：O（nums内不同数字的数量）
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int result = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int nextNum = num + 1;
                int longestStreak = 1;
                while (numSet.contains(nextNum)) {
                    longestStreak++;
                    nextNum++;
                }
                result = Math.max(result, longestStreak);
            }
        }
        return result;
    }
}
