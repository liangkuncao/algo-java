package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.ListNode;
import com.liangkuncao.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode0101 {
    /**
     * 题型：二叉树
     * 解法：BFS、迭代
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftNodes = new LinkedList<>() {
            {
                offer(root.left);
            }
        };
        Queue<TreeNode> rightNodes = new LinkedList<>() {
            {
                offer(root.right);
            }
        };

        while (leftNodes.size() != 0) {
            int len = leftNodes.size();
            for (int i = 0; i < len; i++) {
                TreeNode left = leftNodes.poll();
                TreeNode right = rightNodes.poll();
                if (left == null && right == null) {
                    continue;
                } else if (left == null || right == null) {
                    return false;
                } else if (left.val != right.val) {
                    return false;
                }
                leftNodes.offer(left.left);
                leftNodes.offer(left.right);
                rightNodes.offer(right.right);
                rightNodes.offer(right.left);
            }
        }
        return true;
    }

    /**
     * 题型：二叉树
     * 解法：递归
     * 时间复杂度：O（N），N是树的节点数
     * 空间复杂度：O（N），N是树的高度
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

    /**
     * 解法：递归
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     * @param root
     * @return
     */
    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric4(root.left, root.right);
    }

    private boolean isSymmetric4(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric4(left.left, right.right) && isSymmetric4(left.right, right.left);
    }

    /**
     * 解法：迭代
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     * @param root
     * @return
     */
    public boolean isSymmetric5(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftRow = new LinkedList<>();
        Queue<TreeNode> rightRow = new LinkedList<>();
        leftRow.offer(root.left);
        rightRow.offer(root.right);
        while (!leftRow.isEmpty()) {
            int size = leftRow.size();
            for (int i = 0; i < size; i++) {
                TreeNode leftNode = leftRow.poll();
                TreeNode rightNode = rightRow.poll();
                if (leftNode == null && rightNode == null) {
                    continue;
                }
                if (leftNode == null || rightNode == null) {
                    return false;
                }
                if (leftNode.val != rightNode.val) {
                    return false;
                }
                leftRow.offer(leftNode.left);
                leftRow.offer(leftNode.right);
                rightRow.offer(rightNode.right);
                rightRow.offer(rightNode.left);
            }
        }
        return true;
    }
}