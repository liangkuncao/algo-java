package com.liangkuncao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char letter = magazine.charAt(i);
            letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char letter = ransomNote.charAt(i);
            int count = letterCount.getOrDefault(letter, 0);
            if (count == 0) {
                return false;
            } else {
                letterCount.put(letter, count - 1);
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        char[] count = new char[26];
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            count[index]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (count[index] == 0) {
                return false;
            }
            count[index]--;
        }
        return true;
    }
}
