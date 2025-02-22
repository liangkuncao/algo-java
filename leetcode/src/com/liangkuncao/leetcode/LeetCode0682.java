package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode0682 {
    public int calPoints(String[] operations) {
        if (operations == null || operations.length == 0) {
            return 0;
        }
        List<Integer> queue = new ArrayList<>();
        for (String op : operations) {
            if (op.compareTo("+") == 0) {
                int size = queue.size();
                int pre = queue.get(size - 1);
                int prePre = queue.get(size - 2);
                queue.add(pre + prePre);
            } else if (op.compareTo("D") == 0) {
                int pre = queue.get(queue.size() - 1);
                queue.add(pre * 2);
            } else if (op.compareTo("C") == 0) {
                queue.remove(queue.size() - 1);
            } else {
                queue.add(Integer.parseInt(op));
            }
        }
        return queue.stream().mapToInt(Integer::intValue).sum();
    }
}
