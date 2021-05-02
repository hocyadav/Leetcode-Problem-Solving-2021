package io.hari.problemsolving2021.leetcode.contest;

import org.junit.Test;

/**
 * @Author hayadav
 * @create 5/2/2021
 */
public class WeeklyContest239May2nd {

    @Test
    public void test1() {
        final int minDistance = getMinDistance(new int[]{1, 2, 3, 4, 5}, 5, 3);
        System.out.println("minDistance = " + minDistance);
        System.out.println("minDistance = " + getMinDistance(new int[]{1}, 1, 0));
        System.out.println("minDistance = " + getMinDistance(new int[]{1, 1, 1, 1, 1, 1}, 1, 0));
        System.out.println("minDistance = " + getMinDistance(new int[]{1,1,1,1,1,10000,10000,10000,10000,10000}, 1, 9));
        /** outputs
         * minDistance = 1
         * minDistance = 0
         * minDistance = 0
         * minDistance = 5
         */
    }

    /**
     * https://leetcode.com/problems/minimum-distance-to-the-target-element/
     * global value
     * iterate -> abs -> update global
     * return global
     */
    public int getMinDistance(int[] nums, int target, int start) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                final int abs = Math.abs(i - start);
                if (abs < result) result = abs;
            }
        }
        return result;
    }
}
