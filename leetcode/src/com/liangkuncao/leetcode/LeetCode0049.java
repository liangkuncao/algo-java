package com.liangkuncao.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
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

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String str) {
        int[] letters = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            letters[ch - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            int count = letters[i];
            char ch = (char) ('a' + i);
            if (count > 0) {
                stringBuilder.append(ch);
                stringBuilder.append(count);
            }
        }
        return stringBuilder.toString();
    }
}
