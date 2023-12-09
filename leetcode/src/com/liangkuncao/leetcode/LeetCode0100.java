package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

public class LeetCode0100 {
    /**
     * 题型：二叉树
     * 解法：DFS，递归
     * 时间复杂度：O(min(m,n))
     * 空间复杂度：O(min(m,n))
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        }
    }
}
