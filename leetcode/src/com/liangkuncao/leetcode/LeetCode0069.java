package com.liangkuncao.leetcode;

public class LeetCode0069 {
    public int mySqrt(int x) {
        int low = 0, high = x;
        int ans = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
