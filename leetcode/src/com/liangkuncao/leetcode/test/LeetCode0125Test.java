package com.liangkuncao.leetcode.test;

import com.liangkuncao.leetcode.LeetCode0125;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode0125Test {
    @Test
    public void test() {
        LeetCode0125 leetCode0125 = new LeetCode0125();
        boolean result = leetCode0125.isPalindrome("A man, a plan, a canal: Panama");
        assertEquals(true, result);
    }

    @Test
    public void test2() {
        LeetCode0125 leetCode0125 = new LeetCode0125();
        boolean result = leetCode0125.isPalindrome("0P");
        assertEquals(false, result);
    }
}