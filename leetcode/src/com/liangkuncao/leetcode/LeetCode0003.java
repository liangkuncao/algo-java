package com.liangkuncao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode0003 {
    /**
     * 题型：字符串
     * 解法：双指针，遍历
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        for (right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (seen.containsKey(rightChar)) {
                left = Math.max(left, seen.get(rightChar) + 1);
            }
            seen.put(rightChar, right);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> uniqueSubString = new HashSet<>();
        int left = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (uniqueSubString.contains(ch)) {
                left++;
                uniqueSubString.remove(s.charAt(left));
                continue;
            } else {
                uniqueSubString.add(ch);
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode0003 leetCode0003 = new LeetCode0003();
        leetCode0003.lengthOfLongestSubstring2("pwwkew");

    }
}
