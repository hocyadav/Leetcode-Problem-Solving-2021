package io.hari.problemsolving2021.leetcode.contest;

import org.junit.Test;

import java.util.*;

/**
 * @Author Hariom Yadav
 * @create 18-04-2021
 */
public class ContestApril18th2021 {

    @Test
    public void test() {
        final boolean pangram = checkIfPangram("abcdefghijklmnopqrstuvwxyz");
        System.out.println("pangram = " + pangram);
        System.out.println("pangram2 = " + checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println("pangram2 = " + checkIfPangram("leetcode"));
    }

    /**
     * pangram = true
     * pangram2 = true
     * pangram2 = false
     */

    @Test
    public void test2() {
        int[][] arr = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        final int[] order = getOrder(arr);
    }

    @Test
    public void test3() {
        final int maxIceCream = maxIceCream(new int[]{1,3,2,4,1}, 7);
        System.out.println("maxIceCream = " + maxIceCream);
        System.out.println("maxIceCream = " + maxIceCream(new int[]{10,6,8,7,7,8}, 5));
        System.out.println("maxIceCream = " + maxIceCream(new int[]{1,6,3,1,2,5}, 20));
    }
    /**
     * maxIceCream = 4
     * maxIceCream = 0
     * maxIceCream = 6
     */

    /**
     * https://leetcode.com/contest/weekly-contest-237/problems/check-if-the-sentence-is-pangram/
     */
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for (char c : sentence.toCharArray()) {
            int index = c - 'a';
            arr[index]++;
        }
        for (int val : arr) {
            if (val == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach : Sort , then iterate and reduce coins
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int i = 0; i < costs.length; i++) {
            final int cost = costs[i];
            if (cost <= coins) {
                coins -= cost;
                count++;
                continue;
            }
            if (cost > coins) break;//optional :reduce average TC
        }
        return count;
    }

    class Node {
        int index;
        int startTime;
        int totalTimeTaken;

        public Node(int index, int startTime, int totalTimeTaken) {
            this.index = index;
            this.startTime = startTime;
            this.totalTimeTaken = totalTimeTaken;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", startTime=" + startTime +
                    ", totalTimeTaken=" + totalTimeTaken +
                    '}';
        }
    }

    //not working
    public int[] getOrder(int[][] tasks) {
//        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                if (o1.startTime < o2.startTime) {
//                    return o1.totalTimeTaken - o2.totalTimeTaken;
//                }
////                if (o1.startTime == o2.startTime) {
////                    return o1.totalTimeTaken - o2.totalTimeTaken;
////                } else {
////
////                }
//            }
//        });

        List<Node> list = new LinkedList<>();
        for (int i = 0; i < tasks.length; i++) {
            final int[] task = tasks[i];
            Node node = new Node(i, task[0], task[1]);
            list.add(node);
        }
        Collections.sort(list, (a, b) -> {
            if (a.startTime == b.startTime)
                return a.totalTimeTaken - b.totalTimeTaken;
            else {
                return b.totalTimeTaken - a.totalTimeTaken;
            }
        });
        System.out.println("list = " + list);

        return new int[]{};
    }
}
