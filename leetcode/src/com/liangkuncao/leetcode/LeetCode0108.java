package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

public class LeetCode0108 {
    /**
     * 题型：二叉树
     * 题解：分治
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    private TreeNode help(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums, left, mid - 1);
        node.right = help(nums, mid + 1, right);
        return node;
    }
}
