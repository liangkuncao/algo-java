package com.liangkuncao.leetcode;

public class LeetCode0121 {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            if (price > lowest) {
                result = Math.max(result, price - lowest);
            } else {
                lowest = price;
            }
        }
        return result;
    }
}
