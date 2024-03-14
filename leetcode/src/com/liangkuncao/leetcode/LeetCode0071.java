package com.liangkuncao.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode0071 {
    /**
     * 题型：字符串
     * 解法：栈
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> pathLevels = new Stack<>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < path.length() + 1; i++) {
            if (i == path.length() || path.charAt(i) == '/') {
                String curLevel = cur.toString();
                if (curLevel.equals(".")
                        || curLevel.isEmpty()
                        || curLevel.equals("/")) {
                    cur.setLength(0);
                    continue;
                }
                if (curLevel.equals("..")) {
                    if (!pathLevels.isEmpty()) {
                        pathLevels.pop();
                    }
                    cur.setLength(0);
                    continue;
                }
                pathLevels.push(curLevel);
                cur.setLength(0);
            } else {
                cur.append(path.charAt(i));
            }
        }
        return "/" + String.join("/", pathLevels);
    }

    public static void main(String[] args) {
        LeetCode0071 leetCode0071 = new LeetCode0071();
        String result = leetCode0071.simplifyPath("/a//b////c/d//././/..");
        System.out.println(result);
    }
}
