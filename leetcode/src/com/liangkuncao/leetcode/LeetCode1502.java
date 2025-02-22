package com.liangkuncao.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Set<Double> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            set.add((double) num);
        }
        double interval = ((double) (max - min)) / (arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(min + i * interval)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1502 leetCode1502 = new LeetCode1502();
        int[] arr = new int[] {0, 0, 1};
        boolean result = leetCode1502.canMakeArithmeticProgression(arr);
        System.out.println(result);
    }
}
