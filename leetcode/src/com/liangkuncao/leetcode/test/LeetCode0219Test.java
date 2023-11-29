package com.liangkuncao.leetcode.test;

import com.liangkuncao.leetcode.LeetCode0219;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class LeetCode0219Test {
    @Test
    public void test() {
        int[] nums = {1,2,3,1,2,3};
        LeetCode0219 leetCode0219 = new LeetCode0219();
        boolean res = leetCode0219.containsNearbyDuplicate(nums, 2);
        assertEquals(false, res);
    }
}
