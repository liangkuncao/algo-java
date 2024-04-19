package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode0099 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> inOrderNodes = new ArrayList<>();
        getNodesInOrder(root, inOrderNodes);
        for (int i = 0; i < inOrderNodes.size(); i++) {
            System.out.print(inOrderNodes.get(i).val);
            System.out.print(" ");
        }
        Map<Integer, Integer> swappedNodes = getSwappedNodes(inOrderNodes);
        System.out.println(swappedNodes);
        fixError(root, swappedNodes);
    }

    private void fixError(TreeNode root, Map<Integer, Integer> swappedNodes) {
        if (root == null || swappedNodes.isEmpty()) {
            return;
        }
        fixError(root.left, swappedNodes);
        if (swappedNodes.containsKey(root.val)) {
            root.val = swappedNodes.remove(root.val);
        }
        fixError(root.right, swappedNodes);
    }

    private Map<Integer, Integer> getSwappedNodes(List<TreeNode> nums) {
        Map<Integer, Integer> nodes = new HashMap<>();
        int index1 = -1, index2 = -1;
        for (int i = 0; i < nums.size() - 1; ++i) {
            if (nums.get(i + 1).val < nums.get(i).val) {
                index2 = i + 1;
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        nodes.put(nums.get(index1).val, nums.get(index2).val);
        nodes.put(nums.get(index2).val, nums.get(index1).val);
        return nodes;
    }

    private void getNodesInOrder(TreeNode root, List<TreeNode> inOrderNodes) {
        if (root == null) {
            return;
        }
        getNodesInOrder(root.left, inOrderNodes);
        inOrderNodes.add(root);
        getNodesInOrder(root.right, inOrderNodes);
    }
}
