package com.liangkuncao.leetcode;

import com.liangkuncao.leetcode.common.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeetCode0133 {
    /**
     * 题型：图
     * 解法：BFS
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Node result = new Node(node.val);
        Queue<Node> originalNodes = new LinkedList<>();
        Map<Integer, Node> newNodes = new HashMap<>();
        originalNodes.offer(node);
        newNodes.put(result.val, result);
        while (!originalNodes.isEmpty()) {
            Node cur = originalNodes.poll();
            Node newCur = newNodes.get(cur.val);
            List<Node> nodes = cur.neighbors;
            for (Node neighbor : nodes) {
                Node newNeighbor = newNodes.getOrDefault(neighbor.val, new Node(neighbor.val));
                newCur.neighbors.add(newNeighbor);
                if (!newNodes.containsKey(neighbor.val)) {
                    newNodes.put(newNeighbor.val, newNeighbor);
                    originalNodes.offer(neighbor);
                }
            }
        }
        return result;
    }

    public Node cloneGraphDfs(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> visited = new HashMap<>();
        Node result = new Node(node.val);
        dfs(result, node, visited);
        return result;
    }

    private void dfs(Node result, Node node, Map<Integer, Node> visited) {
        if (visited.containsKey(node.val)) {
            return;
        }
        visited.put(result.val, result);
        for (Node neighbor : node.neighbors) {
            Node newNeighbor = visited.getOrDefault(neighbor.val, new Node(neighbor.val));
            result.neighbors.add(newNeighbor);
            dfs(newNeighbor, neighbor, visited);
        }
    }
}
