package com.liangkuncao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode0399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Map<String, Double>> equationMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            Map<String, Double> map1 = equationMap.getOrDefault(dividend, new HashMap<>());
            map1.put(divisor, values[i]);
            equationMap.put(dividend, map1);

            Map<String, Double> map2 = equationMap.getOrDefault(divisor, new HashMap<>());
            map2.put(dividend, 1 / values[i]);
            equationMap.put(divisor, map2);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if (!equationMap.containsKey(dividend) || !equationMap.containsKey(divisor)) {
                result[i] = -1.0d;
            } else {
                result[i] = bfs(equationMap, dividend, divisor);
            }
        }
        return result;
    }

    private double bfs(Map<String, Map<String, Double>> equationMap, String dividend, String divisor) {
        if (dividend.equals(divisor)) {
            return 1.0d;
        }
        Set<String> visited = new HashSet<>();
         Queue<String> queue = new LinkedList<>();
         Queue<Double> scoreQueue = new LinkedList<>();
         queue.offer(dividend);
         scoreQueue.offer(1.0d);
         while (!queue.isEmpty()) {
             String cur = queue.poll();
             double curScore = scoreQueue.poll();
             visited.add(cur);
             Map<String, Double> neighbors = equationMap.get(cur);
             for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
                 String next = neighbor.getKey();
                 if (visited.contains(next)) {
                     continue;
                 }
                 Double value = neighbor.getValue();
                 double nextValue = curScore * value;
                 if (next.equals(divisor)) {
                     return nextValue;
                 }
                 queue.offer(next);
                 scoreQueue.offer(nextValue);
             }
         }
         return -1.0d;
    }
}
