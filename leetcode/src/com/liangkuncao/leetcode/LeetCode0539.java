package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0539 {

    private int pre = -1;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        List<TreeNode> nodes = dfs(root);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < nodes.size(); i++) {
            result = Math.min(result, nodes.get(i).val - nodes.get(i - 1).val);
        }
        return result;
    }

    private List<TreeNode> dfs(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        nodes.addAll(dfs(root.left));
        nodes.add(root);
        nodes.addAll(dfs(root.right));
        return nodes;
    }

    public int getMinimumDifference2(TreeNode root) {
        dfs2(root);
        return minDiff;
    }

    private void dfs2(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(root.left);
        if (pre != -1) {
            minDiff = Math.min(minDiff, root.val - pre);
        }
        pre = root.val;
        dfs2(root.right);
    }




}
