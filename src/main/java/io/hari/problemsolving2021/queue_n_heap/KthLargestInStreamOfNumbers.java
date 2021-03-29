package io.hari.problemsolving2021.queue_n_heap;

import java.util.PriorityQueue;

/**
 * @Author Hariom Yadav
 * @create 29-03-2021
 */
public class KthLargestInStreamOfNumbers {//same as top kth largest elements

    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        kthLargetInStream(arr, 3);
        //add in arr as stream and call kthLargetInStream
    }

    private static void kthLargetInStream(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int i = 0; i < arr.length; i++) {
            addFun(pq, arr[i], k);
        }
        System.out.println(pq.peek());

    }

    private static void addFun(PriorityQueue<Integer> pq, int val, int k) {
        if (pq.size() < k) pq.add(val);
        else if (val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }
    }
}
/**
 4
 */
