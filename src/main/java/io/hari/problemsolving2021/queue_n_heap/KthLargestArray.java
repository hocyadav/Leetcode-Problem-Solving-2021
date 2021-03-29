package io.hari.problemsolving2021.queue_n_heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author Hariom Yadav
 * @create 29-03-2021
 */
public class KthLargestArray {
    public static void main(String[] args) {
        final int[] arr = {3, 2, 1, 5, 6, 4};
        kthLargest_usingPQ(arr, 2);// 5
        kthLargest_usingPQ(new int[]{3,2,3,1,2,4,5,5,6}, 4);// 4

        kthLarget_usingSort(arr, 2);//5
        kthLarget_usingSort(new int[]{3,2,3,1,2,4,5,5,6}, 4);// 4
    }

    private static void kthLarget_usingSort(int[] arr, int k) {
        Arrays.sort(arr);
        //add null check optional
        if (arr.length - k < 0) return;

        final int kthLarget = arr[arr.length - k];
        System.out.println(kthLarget);
    }

    private static void kthLargest_usingPQ(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int val : arr) addToPQ(pq, k, val);

        final Integer peek = pq.peek();
        System.out.println(peek);
    }

    private static void addToPQ(PriorityQueue<Integer> pq, int k, int val) {
        if(pq.size() < k) {
            pq.add(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }
    }

    //not working
//    public static void addToPQ2(PriorityQueue<Integer> pq, int k, int val) {
//        if (!pq.isEmpty() && val > pq.peek()) pq.poll();//remove
//        pq.add(val);//1. always add
//    }
}

/**
 5
 4
 5
 4
 */
