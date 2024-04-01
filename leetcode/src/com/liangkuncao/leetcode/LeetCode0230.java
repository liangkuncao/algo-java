package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;
import com.liangkuncao.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0230 {
    TreeNode node = null;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        preTravel(root);
        return node.val;
    }

    private void preTravel(TreeNode root) {
        if (k <= 0) {
            return;
        }
        if (root == null) {
            return;
        }
        preTravel(root.left);
        k--;
        if (k == 0) {
            node = root;
        }
        preTravel(root.right);
    }
}
