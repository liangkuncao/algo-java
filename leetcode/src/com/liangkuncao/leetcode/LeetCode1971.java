package com.liangkuncao.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int v : adj[cur]) {
                if (v == destination) {
                    return true;
                }
                if (!seen.contains(v)) {
                    queue.offer(v);
                    seen.add(v);
                }
            }
        }
        return false;
    }
}
