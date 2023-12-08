package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode0104 {
    /**
     * 题型：二叉树
     * 解决方案：递归、DFS
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth_BFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodes = new LinkedList<>() {
        };
        nodes.offer(root);
        int result = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            result++;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }

        }
        return result;
    }
}
