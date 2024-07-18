package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;
import com.sun.source.tree.Tree;

public class LeetCode0543 {
    int result;

    /**
     * 解法：DFS
     * 时间复杂度：O（N）
     * 空间复杂度：O（height）
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        maxDepth(root);
        return result - 1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        result = Math.max(result, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
