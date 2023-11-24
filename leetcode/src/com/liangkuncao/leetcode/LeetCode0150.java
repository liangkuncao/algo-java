package com.liangkuncao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0150 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> ch2Str = new HashMap<>();
        Map<String, Character> str2Ch = new HashMap<>();
        int beginIndex = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (beginIndex >= s.length()) {
                return false;
            }
            Character ch = pattern.charAt(i);
            int endIndex = beginIndex;
            while (endIndex < s.length() && s.charAt(endIndex) != ' ') {
                endIndex++;
            }
            String str = s.substring(beginIndex, endIndex);
            if ((ch2Str.containsKey(ch) && !str.equals(ch2Str.get(ch))) ||
                    (str2Ch.containsKey(str) && !ch.equals(str2Ch.get(str)))) {
                return false;
            }
            ch2Str.put(ch, str);
            str2Ch.put(str, ch);
            beginIndex = endIndex + 1;
        }
        return beginIndex >= s.length();
    }
}
