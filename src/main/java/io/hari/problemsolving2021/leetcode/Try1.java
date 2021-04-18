package io.hari.problemsolving2021.leetcode;

import org.junit.Test;

/**
 * @Author Hariom Yadav
 * @create 15-03-2021
 */
public class Try1 {
    /**
     * 1. 1st window sum
     * 2. other window sum
     */
    public int slidingWindows(int[] arr, int k) {
        int firstWindowSum = 0;
        for (int i = 0; i < k; i++) {
            firstWindowSum += arr[i];
        }
        int localWindow = firstWindowSum;
        for (int i = k; i < arr.length; i++) {
            localWindow += arr[i] - arr[i - k];
//            if (localWindow < 0) localWindow = 0; //this required in kadens
            firstWindowSum = Math.max(firstWindowSum, localWindow);
        }
        return firstWindowSum;
    }

    public int kadensAlgoMaxSumOfAnyWindowSize(int[] arr) {
        int globalWindowSum = 0;
        int firstWindowSum = 0;
        for (int i = 0; i < arr.length; i++) {
            firstWindowSum += arr[i];
            if (firstWindowSum < 0) firstWindowSum = 0;
            globalWindowSum = Math.max(globalWindowSum, firstWindowSum);
        }
        return globalWindowSum;
    }

    @Test
    public void testSlidingWindows() {
        int[] arr = new int[]{10, 2, 3, -1, -3, 1};
        final int maxWindowSum = slidingWindows(arr, 2);
        System.out.println("maxWindowSum = " + maxWindowSum);

        final int anyWindowSize = kadensAlgoMaxSumOfAnyWindowSize(arr);
        System.out.println("anyWindowSize = " + anyWindowSize);
    }

    public static void slidingWindowSumGEtotarget(int[] arr, int targetSum) {
        int len = arr.length;
        int p1 = 0, p2 = 0;
        int localSum = 0;
        int result = Integer.MAX_VALUE;
        while (p1 < len) {
            while (localSum <= targetSum && p1 < len){
                localSum += arr[p1++];
            }
            while (localSum < targetSum && p2 < len){
                result = Math.min(p1 - p2, result);
                localSum -= arr[p2++];
            }
        }
        System.out.println("result = " + result);
    }

    @Test
    public void testSlidingWindowSumGE() {
        int[] arr2 = new int[]{1, 4, 45, 6, 10, 19};
        slidingWindowSumGEtotarget(arr2, 51);
    }

    public static void main(String[] args) {
        int[] arr2 = new int[]{1, 4, 45, 6, 10, 19};
        slidingWindowSumGEtotarget(arr2, 51);
    }
}
