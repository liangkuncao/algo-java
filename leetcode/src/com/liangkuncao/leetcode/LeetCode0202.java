package com.liangkuncao.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode0202 {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            } else {
                seen.add(n);
            }
            int total = 0;
            while (n > 0) {
                total += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = total;
        }
        return true;
    }
}
