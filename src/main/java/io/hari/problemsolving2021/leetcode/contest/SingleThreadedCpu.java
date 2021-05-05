package io.hari.problemsolving2021.leetcode.contest;

import org.junit.Test;

import java.util.*;

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

        final int[] order31 = getOrder3(new int[][]{{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}});
        System.out.println("order31 = " + Arrays.toString(order31));

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
                continue;
            } else if (!pq.isEmpty()) {//process single task : case 2: pick one task + execute(store index)
                final int[] bestFit = pq.poll();
                final int index = bestFit[0];
                final int processingTime = bestFit[2];

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

    class Node {
        int start;
        int process;
        int index;

        public Node(int start, int process, int index) {
            this.start = start;
            this.process = process;
            this.index = index;
        }
    }

    public int[] getOrder3(int[][] tasks) {
        List<Integer> result = new LinkedList<>();
        int n = tasks.length;

        final List<Node> list = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) list.add(new Node(tasks[i][0], tasks[i][1], i));
        Collections.sort(list, (a, b) -> a.start - b.start);

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.process == b.process ? a.index - b.index : a.process - b.process);
        int index = 0, time = 0;
        while (result.size() < n) {//0 to n, initially size is 0
            while (index < n && list.get(index).start <= time){
                minHeap.add(list.get(index));
                index++;
            }
            if (minHeap.isEmpty()) {
                time = list.get(index).start;
                continue;
            }
            final Node top = minHeap.poll();
            result.add(top.index);
            time += top.process;
        }
        System.out.println("result = " + result);
        final Integer[] toArray = result.stream().toArray(Integer[]::new);
        System.out.println("toArray = " + toArray);
        final int[] ints = result.stream().mapToInt(x -> x).toArray();
        return ints;
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
