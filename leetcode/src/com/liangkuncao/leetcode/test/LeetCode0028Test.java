package com.liangkuncao.leetcode.test;

import com.liangkuncao.leetcode.LeetCode0028;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCode0028Test {
    @Test
    public void testPass() {
        LeetCode0028 leetCode0028 = new LeetCode0028();
        int result = leetCode0028.strStr("a", "a");
        assertEquals(0, result);
    }

    @Test
    public void testFail() {
        LeetCode0028 leetCode0028 = new LeetCode0028();
        int result = leetCode0028.strStr("leetcode", "leetcdd");
        assertEquals(-1, result);
    }

    @Test
    public void testKmp() {
        LeetCode0028 leetCode0028 = new LeetCode0028();
        int result = leetCode0028.strStrKmp("opqwabcabdefabcabbe", "abcabb");
        assertEquals(12, result);
    }
}
