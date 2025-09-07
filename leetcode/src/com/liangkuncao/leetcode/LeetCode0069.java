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

    public int mySqrt_0907(int x) {
        int left = 0;
        int right = x;
        int result = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
