package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int rootValue = preorder[0];
        int leftSize = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                leftSize = i;
                break;
            }
        }
        int rightSize = preorder.length - leftSize - 1;

        int[] leftPreorder = new int[leftSize];
        int[] rightPreorder = new int[rightSize];
        int[] leftInorder = new int[leftSize];
        int[] rightInorder = new int[rightSize];
        System.arraycopy(preorder, 1, leftPreorder, 0, leftSize);
        System.arraycopy(preorder, leftSize + 1, rightPreorder, 0, rightSize);
        System.arraycopy(inorder, 0, leftInorder, 0, leftSize);
        System.arraycopy(inorder, leftSize + 1, rightInorder, 0, rightSize);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree3(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree3(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        int rootIndex = map.get(preorder[preorderLeft]);
        int leftSize = rootIndex - inorderLeft;
        root.left = buildTree3(preorder, inorder, preorderLeft + 1, preorderLeft + leftSize, inorderLeft, rootIndex - 1);
        root.right = buildTree3(preorder, inorder, preorderLeft + 1 + leftSize, preorderRight, rootIndex + 1, inorderRight);
        return root;
    }

    public static void main(String[] args) {

    }
}
