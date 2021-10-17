package io.hari.problemsolving2021.leetcode.easy;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
public class MinimumDifferenceBWHighestAndLowest {
    @Test
    public void foo() {
        System.out.println("difference2 = " + minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }


    //sort
    //find min ele and max ele in bucket of size k
    public int minimumDifference(int[] nums, int k) {
        int minResult = Integer.MAX_VALUE;

        System.out.println("nums = " + Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int lastIndexInBucket = i + k - 1;
            //take k = 2 , 0 + 2 = 2 , i.e. first ele is 0 and last ele is 2 , i.e. total 3 element in bucket, we want 2, so substract 1
            if (lastIndexInBucket >= nums.length) break;
            int max = nums[lastIndexInBucket];
            System.out.println("min max index : " + i + ", " + lastIndexInBucket);

            minResult = Math.min(minResult, max - min);
        }

        return minResult;
    }
}
