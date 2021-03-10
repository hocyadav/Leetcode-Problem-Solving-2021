package io.hari.problemsolving2021.leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * @Author Hariom Yadav
 * @create 09-03-2021
 */
class Map2Node {
    int id, wt;
    Map2Node(int id, int wt) {
        this.id = id;
        this.wt = wt;
    }
}

class Queue3Node {
    int id, dist, cost;
    Queue3Node(int id, int dist, int cost) {
        this.id = id;
        this.dist = dist;
        this.cost = cost;
    }
}

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // DFS
        if(n <= 0 || flights == null || flights.length == 0 || K < 0)
            return -1;

        Map<Integer, List<Map2Node>> map = new HashMap<>();
        Map<Integer, List<Pair>> map2 = new HashMap<>();
        buildMap(map, flights);
        buildMap2(map2, flights);

        Queue<Queue3Node> pq = new PriorityQueue<>((c1, c2) -> c1.cost - c2.cost);
        pq.add(new Queue3Node(src, 0, 0));

        int totalCost = 0;

        while (!pq.isEmpty()) {
            Queue3Node top = pq.poll();
            final int id = top.id;
            final int cost = top.cost;
            final int dist = top.dist;

            if (id == dst) {
                return cost;
            }
            if (dist > K) {//skip this path and go to some other direction
                continue;
            }
            for (Map2Node c: map.get(id)) {
                pq.offer(new Queue3Node(c.id, dist + 1, c.wt + cost));
            }
        }
        return -1;
    }

    private void buildMap2(Map<Integer, List<Pair>> map2, int[][] flights) {
        for (int[] f : flights) {
            map2.putIfAbsent(f[0], new LinkedList<>());
            map2.get(f[0]).add(new Pair<>(f[1], f[2]));
        }
    }

    private void buildMap(Map<Integer, List<Map2Node>> map, int[][] flights) {
        for (int[] f : flights) {
            final int key = f[0];
            final int destination = f[1];
            final int wt = f[2];

            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(new Map2Node(destination, wt));
        }
    }
}
