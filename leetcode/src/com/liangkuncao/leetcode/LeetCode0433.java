package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LeetCode0433 {
    static List<Character> chars = new ArrayList<>();

    static {
        chars.add('A');
        chars.add('C');
        chars.add('G');
        chars.add('T');
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }

        Set<String> bankMap = new HashSet<>(Arrays.asList(bank));
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (endGene.equals(cur)) {
                    return result;
                }
                seen.add(cur);
                for (int j = 0; j < 8; j++) {
                    queue.addAll(getNexts(cur, j, seen, bankMap));
                }
            }
            result++;
        }
        return -1;
    }

    private List<String> getNexts(String cur, int j, Set<String> seen, Set<String> bank) {
        StringBuilder stringBuilder = new StringBuilder(cur);
        List<String> result = new ArrayList<>();
        for (Character ch : chars) {
            if (cur.charAt(j) != ch) {
                stringBuilder.setCharAt(j, ch);
                if (seen.contains(stringBuilder.toString())) {
                    continue;
                }
                if (!bank.contains(stringBuilder.toString())) {
                    continue;
                }
                result.add(stringBuilder.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode0433 leetCode0433 = new LeetCode0433();
        String[] bank = new String[] {"AACCGGTA"};
        leetCode0433.minMutation("AACCGGTT", "AACCGGTA", bank);
    }
}
