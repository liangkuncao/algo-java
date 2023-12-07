package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

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
}
