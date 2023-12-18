package com.liangkuncao.leetcode;

public class LeetCode0067 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        if (aLen < bLen) {
            return addBinary(b, a);
        }
        int diff = aLen - bLen;
        int carry = 0;
        for (int i = aLen - 1; i >= 0; i--) {
            int aInt = a.charAt(i) - '0';
            int j = i - diff;
            int bInt = j < 0 ? 0 : b.charAt(j) - '0';
            int total = carry + aInt + bInt;
            carry = total / 2;
            result.append((char)(total % 2) + '0');
        }
        if (carry > 0) {
            result.append((char)(carry + '0'));
        }
        return result.reverse().toString();
    }
}
