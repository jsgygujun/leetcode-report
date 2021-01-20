package com.jsgygujun.code.problem._01245_树的直径;
import org.junit.Test;

import java.util.*;
/**
 * @author GuJun
 * @date 2021/1/14
 */
public class Solution {

    public int treeDiameter(int[][] edges) {
        Map<Integer, Set<Integer>> adjList = buildAdjList(edges);
        int[] res = bfs(adjList, 0);
        res = bfs(adjList, res[0]);
        return res[1];
    }

    private int[] bfs(Map<Integer, Set<Integer>> adjList, int start) {
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        int farthestNode = -1, farthestDist = 0; // 最远节点，最远距离
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            farthestNode = poll[0];
            farthestDist = poll[1];
            for (int node : adjList.get(farthestNode)) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    queue.offer(new int[]{node, farthestDist+1});
                }
            }
        }
        return new int[]{farthestNode, farthestDist};
    }

    // 构建邻接表
    private Map<Integer, Set<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>(edges.length);
        for (int i = 0; i < edges.length; ++i) {
            if (!adjList.containsKey(edges[i][0])) adjList.put(edges[i][0], new HashSet<>());
            if (!adjList.containsKey(edges[i][1])) adjList.put(edges[i][1], new HashSet<>());
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        return adjList;
    }

    @Test
    public void test() {
        int[][] edges = new int[5][2];
        edges[0] = new int[]{0,1};
        edges[1] = new int[]{1,2};
        edges[2] = new int[]{2,3};
        edges[3] = new int[]{1,4};
        edges[4] = new int[]{4,5};
        System.out.println(new Solution().treeDiameter(edges));
    }

    @Test
    public void test2() {
        int[][] edges = new int[2][2];
        edges[0] = new int[]{0,1};
        edges[1] = new int[]{0,2};
        System.out.println(new Solution().treeDiameter(edges));
    }
}
