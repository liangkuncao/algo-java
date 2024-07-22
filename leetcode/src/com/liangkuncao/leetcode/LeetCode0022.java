package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0022 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        trackBack(2 * n, 0, 0, result, new StringBuilder());
        return result;
    }

    private void trackBack(int total, int leftCount, int rightCount, List<String> result, StringBuilder cur) {
        if (total < 0) {
            return;
        }
        if (leftCount < rightCount) {
            return;
        }
        if (total == 0) {
            if (leftCount == rightCount) {
                result.add(cur.toString());
                return;
            }
            return;
        }
        cur.append('(');
        trackBack(total - 1, leftCount + 1, rightCount, result, cur);
        cur.deleteCharAt(cur.length() - 1);

        cur.append(')');
        trackBack(total - 1, leftCount, rightCount + 1, result, cur);
        cur.deleteCharAt(cur.length() - 1);
    }
}
