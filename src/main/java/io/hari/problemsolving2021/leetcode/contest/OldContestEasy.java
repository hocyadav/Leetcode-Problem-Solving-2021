package io.hari.problemsolving2021.leetcode.contest;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/biweekly-contest-60/problems/find-the-middle-index-in-array/
 * https://leetcode.com/problems/find-pivot-index/submissions/
 */
public class OldContestEasy {
    @Test
    public void foo() {
//        int middleIndex = findMiddleIndex(new int[]{1, 2, 1,});
        System.out.println("middleIndex2 = " + findMiddleIndex2(new int[]{1, 2, 1,}));

    }

    //wrong sol
    public int findMiddleIndex(int[] nums) {
        int result = 0;
        int[] left = new int[nums.length + 1];
        int[] right = new int[nums.length + 1];

        for (int i = 0; i < left.length; i++) {
            if (i == 0) left[0] = 0;
            else left[i] = left[i - 1] + nums[i - 1];
        }
        Arrays.stream(left).forEach(System.out::println);
        System.out.println();

        int lastIndex = right.length - 1;
        int l = nums.length - 1;
        for (int i = lastIndex; i >= 0; i--) {
            if (i == right.length - 1) right[right.length - 1] = 0;
            else {
                right[i] = right[i + 1] + nums[l];
                l--;
            }
        }
        Arrays.stream(right).forEach(System.out::println);
        return result;
    }

    //correct solution
    public int findMiddleIndex2(int[] nums) {
        int result = 0;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] + nums[i];
        }
        Arrays.stream(left).forEach(System.out::println);
        System.out.println();

        int l = nums.length - 1;
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i];
        }
        Arrays.stream(right).forEach(System.out::println);

        for (int i = 0; i < nums.length; i++) {
            if (left[i] == right[i]) return i;
        }

        return -1;
    }
}
