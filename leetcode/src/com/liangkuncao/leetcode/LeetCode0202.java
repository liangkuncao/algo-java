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

    public boolean isHappy_fast_slow_pointer(int n) {
        int slow = n, fast = getSqrtSum(n);
        while (slow != fast) {
            slow = getSqrtSum(slow);
            fast = getSqrtSum(getSqrtSum(fast));
            if (fast == 1) {
                return true;
            }
        }
        return fast == 1;
    }

    private int getSqrtSum(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}
