package com.liangkuncao.leetcode;

public class LeetCode0201 {
    /**
     * 位移
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        return left << count;
    }

    /**
     * 超时
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd2(int left, int right) {
        double a = Math.log(left) / Math.log(2);
        double b = Math.log(right) / Math.log(2);
        if (a + 1 < b) {
            return 0;
        }
        int result = left & right;
        if (left == right) {
            return result;
        }
        for (int i = left + 1; i < right; i++) {
            if (result == 0) {
                break;
            }
            result &= i;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode0201 leetCode0201 = new LeetCode0201();
        leetCode0201.rangeBitwiseAnd2(2147483647, 2147483647);
    }
}