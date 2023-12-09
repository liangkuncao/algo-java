package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

public class LeetCode0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
