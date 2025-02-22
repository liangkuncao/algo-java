package com.liangkuncao.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode0682Test {

    @Test
    void calPoints() {
        LeetCode0682 leetCode0682 = new LeetCode0682();
        String[] operations = new String[] {
                "5","2","C","D","+"
        };
        int result = leetCode0682.calPoints(operations);
        Assertions.assertEquals(result, 30);
    }
}