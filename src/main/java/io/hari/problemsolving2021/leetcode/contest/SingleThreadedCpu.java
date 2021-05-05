package io.hari.problemsolving2021.leetcode.contest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author hayadav
 * @create 5/3/2021
 */
public class SingleThreadedCpu {

    @Test
    public void testSingleThreadedCPU() {
        final int[] order = getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}});
        System.out.println("order1 = " + Arrays.toString(order));//[0, 2, 3, 1]

        final int[] order2 = getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}});
        System.out.println("order2 = " + Arrays.toString(order2));//[4, 3, 2, 0, 1]
    }

    /**
     * https://leetcode.com/problems/single-threaded-cpu/
     * Approach:
     * Step 1: storing index : create new array that store input array with index
     * Step 2: create producer for cpu : create pq for fetching task for cpu
     * step 3: traverse input array -> 1.store in pq (producer object) -> 2.fetch from pq (consume object)
     */
    public int[] getOrder(int[][] tasks) {
        int[] result = new int[tasks.length];
        int[][] arr = storeIndex(tasks);//step 1
        PriorityQueue<int[]> pq = getPriorityQueue();//step 2

        int resultIndex = 0;
        int currentTime = 0;
        int it = 0;
        while (it < tasks.length) {//step 3
            while (it < tasks.length && arr[it][1] <= currentTime) {
                pq.add(arr[it]);
                it++;//move pointer
            }
            if (pq.isEmpty()) { //case 1: no task in heap, move time to next task start time
                currentTime = arr[it][1];//next start time
            } else if (!pq.isEmpty()) {//process single task : case 2: pick one task + execute(store index)
                final int[] curr = pq.poll();
                final int index = curr[0];
                final int processingTime = curr[2];

                result[resultIndex++] = index;
                currentTime += processingTime;
            }
        }
        //finish rest of task from queue
        while (!pq.isEmpty()) {//case 3: pick one by one + execute(store index)
            final int[] curr = pq.poll();
            final int index = curr[0];

            result[resultIndex++] = index;
        }
        return result;
    }

    private int[][] storeIndex(int[][] tasks) {
        final int[][] arr = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            final int index = i;
            final int startTime = tasks[i][0];
            final int processingTime = tasks[i][1];
            arr[i] = new int[]{index, startTime, processingTime};
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);//on start time
        return arr;
    }

    private PriorityQueue<int[]> getPriorityQueue() {
        final Comparator<int[]> comparator = (a, b) -> {
            final int startTime1 = a[1];
            final int startTime2 = b[1];

            final int processingTime1 = a[2];
            final int processingTime2 = b[2];

            if (processingTime1 != processingTime2) // processing time different
                return processingTime1 - processingTime2;
            else{ // processing time same
                return startTime1 - startTime2;
            }
        };
        return new PriorityQueue<>(comparator);
    }
}
