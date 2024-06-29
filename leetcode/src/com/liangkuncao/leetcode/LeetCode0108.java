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

    public TreeNode sortedArrayToBST2(int[] nums) {
        return help2(nums, 0, nums.length);
    }

    private TreeNode help2(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help2(nums, left, mid);
        node.right = help2(nums, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        LeetCode0108 leetCode0108 = new LeetCode0108();
        int[] nums = {-10,-3,0,5,9};
        leetCode0108.sortedArrayToBST2(nums);

    }

}
