package io.hari.problemsolving2021.queue_n_heap;

import java.util.*;

/**
 * @Author Hariom Yadav
 * @create 29-03-2021
 */
public class TopKFrequentElement {
    public static void main(String[] args) {
        final int[] arr = {1, 1, 1, 2, 2, 3};
        topKFrequent(arr, 2);
        topKFrequent(new int[]{1}, 1);
        topKFrequent(new int[]{1}, 100);
    }

    private static void topKFrequent(int[] arr, int k) {
        if (k > arr.length) return;//null checks

        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxheap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxheap.add(entry);
        }

        List<Integer> result = new LinkedList<>();
        while (result.size() < k) {
            final Map.Entry<Integer, Integer> curr = maxheap.poll();
            result.add(curr.getKey());
        }
        System.out.println(result);
    }
}

/**
 [1, 2]
 [1]
 */
