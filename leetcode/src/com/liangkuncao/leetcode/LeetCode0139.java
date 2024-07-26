package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode0139 {
    boolean result = false;

    /**
     * 超出时间限制
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Character, List<String>> map = classifyWordDict(wordDict);
        help(s, 0, map, new StringBuilder());
        return result;
    }

    private void help(String str, int index, Map<Character, List<String>> map, StringBuilder stringBuilder) {
        if (result) {
            return;
        }
        if (stringBuilder.length() > str.length()) {
            return;
        }
        if (stringBuilder.length() == str.length()) {
            if (str.contentEquals(stringBuilder)) {
                result = true;
            }
            return;
        }
        for (String word : map.getOrDefault(str.charAt(index), new ArrayList<>())) {
            stringBuilder.append(word);
            help(str, index + word.length(), map, stringBuilder);
            stringBuilder.delete(stringBuilder.length() - word.length(), stringBuilder.length());
        }
    }

    private Map<Character, List<String>> classifyWordDict(List<String> wordDict) {
        Map<Character, List<String>> result = new HashMap<>();
        for (String word : wordDict) {
            List<String> list = result.getOrDefault(word.charAt(0), new ArrayList<>());
            list.add(word);
            result.put(word.charAt(0), list);
        }
        return result;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}