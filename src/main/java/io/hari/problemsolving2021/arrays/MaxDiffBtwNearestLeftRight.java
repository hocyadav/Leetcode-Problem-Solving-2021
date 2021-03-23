package io.hari.problemsolving2021.arrays;

import static io.hari.problemsolving2021.arrays.NextGreaterElement_usingRainWaterConcept.printArray;

/**
 * @Author Hariom Yadav
 * @create 23-03-2021
 * https://www.geeksforgeeks.org/find-maximum-difference-between-nearest-left-and-right-smaller-elements/
 */
public class MaxDiffBtwNearestLeftRight {
    public static void main(String[] args) {
        findNearestLeftAndNearestRight(new int[]{2, 1, 8});
        findNearestLeftAndNearestRight(new int[]{2, 4, 8, 7, 7, 9, 3});
        findNearestLeftAndNearestRight(new int[]{5, 1, 9, 2, 5, 1, 7});
    }

    /**
     * 1 Create left array and right array - using same as Next Greatest Equal concept , just change the Smaller Equal
     * 2 then traverse both array and find abs difference
     */
    private static void findNearestLeftAndNearestRight(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        fillRight(right, arr);
        printArray(right);

        fillLeft(left, arr);
        printArray(left);

        findMaxAbsDiff(left, right);
    }

    private static void findMaxAbsDiff(int[] left, int[] right) {
        int maxAbs = Integer.MIN_VALUE;
        for (int i = 0; i < left.length; i++) {//traverse any array length, since both are same length
            final int abs = Math.abs(left[i] - right[i]);
            maxAbs = Math.max(maxAbs, abs);
        }
        System.out.println("maxAbs = " + maxAbs);
    }

    /**
     * set 1st value(last index) as 0
     * Traverse from len --to--> 0
     * compare actual array and update traversal right array
     * @param right
     * @param arr
     */
    private static void fillRight(int[] right, int[] arr) {
        right[arr.length - 1] = 0;
        for (int i = right.length - 2; i >= 0; i--) {
            final int currArrVal = arr[i];
            if (currArrVal >= arr[i + 1]) {
                right[i] = arr[i + 1];
            } else if (currArrVal >= right[i + 1]) {
                right[i] = right[i + 1];
            } else {
                right[i] = 0;
            }
        }
    }

    private static void fillLeft(int[] left, int[] arr) {
        left[0] = 0;
        for (int i = 1; i < left.length; i++) {
            final int currArrVal = arr[i];
            if (arr[i - 1] <= currArrVal) {
                left[i] = arr[i - 1];
            } else if (left[i - 1] <= currArrVal) {
                left[i] = left[i - 1];
            } else {
                left[i] = 0;
            }
        }
    }
}
/**
 1 0 0
 0 0 1
 maxAbs = 1

 0 0 7 7 3 3 0
 0 2 4 4 7 7 0
 maxAbs = 4

 1 0 2 1 1 0 0
 0 0 1 1 2 0 1
 maxAbs = 1
 */
