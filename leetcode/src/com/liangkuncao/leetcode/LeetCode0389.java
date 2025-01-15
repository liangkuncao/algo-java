package com.liangkuncao.leetcode;

public class LeetCode0389 {
    public char findTheDifference(String s, String t) {
        int[] letters = new int[26];
        for (char letter : s.toCharArray()) {
            letters[letter - 'a']++;
        }
        for (char letter : t.toCharArray()) {
            if (letters[letter - 'a'] == 0) {
                return letter;
            }
            letters[letter - 'a']--;
        }
        return t.charAt(0);
    }
}
