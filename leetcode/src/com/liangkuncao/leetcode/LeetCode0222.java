package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

public class LeetCode0222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
