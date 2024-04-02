package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0098 {
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> nodes = new LinkedList<>();
        preTravel(root, nodes);
        return flag;
    }

    private void preTravel(TreeNode root, Deque<TreeNode> nodes) {
        if (root == null) {
            return;
        }

        preTravel(root.left, nodes);

        if (!nodes.isEmpty() && root.val <= nodes.peekLast().val) {
            flag = false;
        }
        if (!flag) {
            return;
        }
        nodes.offer(root);
        preTravel(root.right, nodes);
    }
}
