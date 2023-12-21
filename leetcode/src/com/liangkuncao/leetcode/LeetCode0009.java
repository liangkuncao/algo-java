package com.liangkuncao.leetcode;

public class LeetCode0009 {
    /**
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String numStr = String.valueOf(x);
        int left = 0, right = numStr.length() - 1;
        while (left < right) {
            if (numStr.charAt(left) != numStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        }
        int reverse = 0;
        while (reverse < x) {
            reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }
        return reverse == x || (reverse % 10) == x;
    }
}