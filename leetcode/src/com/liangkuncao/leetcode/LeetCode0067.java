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

    public String addBinary20250402(String a, String b) {
        int carry = 0;
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        StringBuilder result = new StringBuilder();
        while (aIdx >= 0 || bIdx >= 0) {
            int aBit = aIdx >= 0 ? a.charAt(aIdx) - '0' : 0;
            int bBit = bIdx >= 0 ? b.charAt(bIdx) - '0' : 0;
            int sum = aBit + bBit + carry;
            carry = sum / 2;
            int cur = sum % 2;
            result.insert(0, cur);
            aIdx--;
            bIdx--;
        }
        if (carry > 0) {
            result.insert(0, carry);
        }
        return result.toString();
    }
}
