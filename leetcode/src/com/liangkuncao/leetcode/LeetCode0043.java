package com.liangkuncao.leetcode;

public class LeetCode0043 {
    public String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int curSum = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int total = n1 * n2 + carry;
                carry = total / 10;
                int curDigit = total % 10;
                curSum += (int) (curDigit * Math.pow(10, i + j));
            }
            if (carry > 0) {
                curSum += (int) (carry * Math.pow(10, i + num2.length()));
            }
        }
        return String.valueOf(curSum);
    }
}
