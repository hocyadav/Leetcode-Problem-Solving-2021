package io.hari.problemsolving2021.leetcode.contest_2022;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sort-even-and-odd-indices-independently/
 * // approach HL
 * // Goal: fetch highest element each time : solution PQ
 * // Goal: fetch smallest element each time : solution PQ
 *
 *  approach : 2 for loop , one to update PQ, and one to update initial array
 * // 1. store max element at top in PQ -- A
 * // 2. store min element at top in PQ -- B
 * // 3. iterate + if even index add data to A, else B
 * // 4. again iterate + if even index poll from A and add to initial array, else poll from B and add to initial array
 * // return initial array
 */
public class Easy_SortEvenOddIndex {
    @Test
    public void foo() {
        int[] evenOdd2 = sortEvenOdd2(new int[]{1, 2, 3, 55, 666, 9});
        System.out.println("evenOdd2 = " + Arrays.toString(evenOdd2));

    }

    public int[] sortEvenOdd2(int[] nums) {
        System.out.println("nums = " + Arrays.toString(nums));
        PriorityQueue<Integer> pqEven = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer top, Integer input) {//o1: top value in PQ, o2: input value
                return top - input;//2 - 4 , 2 win coz 4 fail(2-4 == -ve so fail), so top will store small value
            }
        });
        PriorityQueue<Integer> pqOdd = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer top, Integer input) {
                return input - top; // 4 - 2, 4 win coz 4 is input and 4 is win(4-2 = +ve), so top will be the big value == that means used for decreasing order
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) pqEven.add(nums[i]);
            else pqOdd.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) nums[i] = pqEven.poll();
            else nums[i] = pqOdd.poll();
        }
        //print PQ
//        while (!pqEven.isEmpty()) {
//            System.out.println("pqEven = " + pqEven.poll());
//        }
//
//        while (! pqOdd.isEmpty()) {
//            System.out.println("pqOdd = " + pqOdd.poll());
//        }
        return nums;
    }

    public int[] sortEvenOdd(int[] nums) {
        int[] t = selectionSort(nums);
        System.out.println(t);
        return t;
    }

    // for loop start to end - 1
    // take 1st value
    // for looop above + 1 : start +1 to (end-1) +1, one step forward to get value
    // compare with 1st value and get smallest/bigger value index
    // swap 2 values
    // repeat
    public int[] selectionSort(int[] nums) {

        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int assumeFirstMinInx = i;

            int startRange = i + 1;             //one step forward
            int lastRange = len - 1 + 1;        //one step forward
            for (int j = startRange; j < lastRange; j++) {
                //finding actual first min value
                if (nums[j] < nums[assumeFirstMinInx]) assumeFirstMinInx = j;
            }
            //swap i and assumeFirstMinInx
            int temp = nums[i];
            nums[i] = nums[assumeFirstMinInx];
            nums[assumeFirstMinInx] = temp;
        }
        return nums;
    }
}
