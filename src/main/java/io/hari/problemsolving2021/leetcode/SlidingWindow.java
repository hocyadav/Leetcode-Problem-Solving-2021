package io.hari.problemsolving2021.leetcode;

import java.util.stream.IntStream;

/**
 * @Author Hariom Yadav
 * @create 10-03-2021
 */
public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 1};
        final int i = slidingSimpleImpl(arr, 3);
        System.out.println("i = " + i);
    }

    // https://www.geeksforgeeks.org/window-sliding-technique/
    //1. 1st k window sum
    //2. find remaining windows as local window and update the 1st max
    public static int slidingSimpleImpl(int[] arr, int k) {
        int maxWindow = 0;
        for (int i = 0; i < k; i++) maxWindow += arr[i];

        int localWindow = maxWindow;
        for (int i = k; i < arr.length; i++) {
            localWindow += arr[i] - arr[i - k];
            maxWindow = Math.max(maxWindow, localWindow);
        }
        return maxWindow;
    }
}
