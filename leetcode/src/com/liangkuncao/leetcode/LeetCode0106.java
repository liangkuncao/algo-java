package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0106 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        if (inorderLeft > inorderRight) {
            return null;
        }
        int rootValue = postorder[postorderRight];
        int rootIndex = map.get(rootValue);
        int leftSize = rootIndex - inorderLeft;
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(inorder, postorder, inorderLeft, rootIndex - 1, postorderLeft, postorderLeft + leftSize - 1);
        root.right = buildTree(inorder, postorder, rootIndex + 1, inorderRight, postorderLeft + leftSize, postorderRight - 1);
        return root;
    }
}
