package com.liangkuncao.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class LeetCode0020 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && map.get(stack.peek()).equals(ch)) {
                stack.pop();
            } else {
                if (!map.containsKey(ch)) {
                    return false;
                }
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }

    public boolean isValid_20240614(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char brace = s.charAt(i);
            if (!stack.isEmpty() && map.get(brace) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(brace);
            }
        }
        return stack.isEmpty();
    }
}
