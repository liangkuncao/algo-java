package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0006 {
    private static final int UPWARD_DIRECTION = 1;
    private static final int DOWNWARD_DIRECTION = -1;
    public String convert(String s, int numRows) {
        StringBuilder[] result = new StringBuilder[numRows];
        for (int i = 0; i < result.length; i++) {
            result[i] = new StringBuilder();
        }
        int direction = DOWNWARD_DIRECTION;
        int curIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            result[curIndex].append(s.charAt(i));
            if (numRows == 1) {
                continue;
            }
            if (curIndex == 0) {
                direction = DOWNWARD_DIRECTION;
            } else if (curIndex == numRows - 1) {
                direction = UPWARD_DIRECTION;
            }
            if (direction == DOWNWARD_DIRECTION) {
                curIndex++;
            } else {
                curIndex--;
            }
        }
        return String.join("", result);
    }
}
