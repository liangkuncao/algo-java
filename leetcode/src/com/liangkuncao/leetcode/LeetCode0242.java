package com.liangkuncao.leetcode;

public class LeetCode0242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] count = new char[26];
        for (int i = 0; i < s.length(); i++) {
            char curCh = s.charAt(i);
            count[curCh - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char curCh = t.charAt(i);
            if (count[curCh - 'a'] == 0) {
                return false;
            }
            count[curCh - 'a']--;
        }
        return true;
    }
}
