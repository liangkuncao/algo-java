package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                count[ch - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    key.append((char) (i + 'a'));
                    key.append(count[i]);
                }
            }
            String k = key.toString();
            List<String> value = result.getOrDefault(k, new ArrayList<>());
            value.add(str);
            result.put(k, value);
        }
        return new ArrayList<>(result.values());
    }
}
