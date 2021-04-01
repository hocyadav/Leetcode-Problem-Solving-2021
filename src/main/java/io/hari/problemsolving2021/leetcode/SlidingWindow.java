package io.hari.problemsolving2021.leetcode;

/**
 * @Author Hariom Yadav
 * @create 10-03-2021
 */
public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 1};
//        final int i = slidingSimpleImpl(arr, 3);
//        System.out.println("i = " + i);

        //todo : given array and sum find length of array that makes sum >= given sum
        // https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
        int[] arr2 = new int[]{1, 4, 45, 6, 10, 19};
        int givenSum = 51;
//        System.out.println("givenSum1 = " + slidingWindowsWithSumGEtoGivenSum(arr2, 51));//4, 45, 6
//        System.out.println("givenSum1 = " + slidingWindowsWithSumGEtoGivenSum(arr2, 2));//4
//        System.out.println("givenSum1 = " + slidingWindowsWithSumGEtoGivenSum_singleLoop(arr2, 51));//4, 45, 6
//        System.out.println("givenSum1 = " + slidingWindowsWithSumGEtoGivenSum_singleLoop(arr2, 2));//4

        System.out.println("givenSum1 = " + countSubarray(3, 1, new int[]{-1, 3, -1}));//4, 45, 6
        System.out.println("givenSum1 = " + countSubarray(7, 2, new int[]{2, -1, 3, 0, 1, 2, 1}));//4, 45, 6

        final long l = countSubarray2(3, 1, new int[]{-1, 3, -1});
//        final long l = countSubarray2(3, 1, new int[]{2, -1, 3, 0, 1, 2, 1});
        System.out.println("l = " + l);

    }

    // https://www.geeksforgeeks.org/window-sliding-technique/
    //1. 1st k window sum
    //2. find remaining windows as local window and update the 1st max
    public static int slidingSimpleImpl(int[] arr, int k) {
        int maxWindow = 0;
        for (int i = 0; i < k; i++)
            maxWindow += arr[i];

        int localWindow = maxWindow;
        for (int i = k; i < arr.length; i++) {
            localWindow += arr[i] - arr[i - k];
            maxWindow = Math.max(maxWindow, localWindow);
        }
        return maxWindow;
    }

    /**
     * 2 pointer solution : one will increase , another will decrease
     * 1. traverse
     * 2. inside traverse a. increasing loop
     * 3. inside traverse b. decreasing loop
     */
    public static int slidingWindowsWithSumGEtoGivenSum(int[] arr, int givenSum) {
        final int len = arr.length;
        int resultMinLen = Integer.MAX_VALUE; //coz we will store min value
        int p1 = 0;
        int p2 = 0;
        int currentSum = 0;
        System.out.println("givenSum = " + givenSum);
        while (p1 < len) {//a. condition of increasing since it will reach last
            while (currentSum <= givenSum && p1 < len) {//a. increase sum
                currentSum += arr[p1];
                p1++;
                System.out.println("currentSum i = " + currentSum);
            }
            while (currentSum > givenSum && p2 < len) {//b. decrease sum
                resultMinLen = Math.min(p1 - p2, resultMinLen); // p2 is fast moving pointer so p2 - p1
                currentSum -= arr[p2];
                p2++;
                System.out.println("resultMinLen = " + resultMinLen);
                System.out.println("currentSum d = " + currentSum);
            }
        }
        System.out.println("currentSum o = " + currentSum);
        return resultMinLen;
    }

    //1. traverse
    // increasing
    // decreasing
    public static int slidingWindowsWithSumGEtoGivenSum_singleLoop(int[] arr, int givenSum) {
        int resultMinLen = Integer.MAX_VALUE;

        int localWindowSum = 0;
        int l = 0;
        System.out.println("givenSum = " + givenSum);
        for (int r = 0; r < arr.length; r++) {
            localWindowSum += arr[r];
            System.out.println("localWindowSum i = " + localWindowSum);

            while (localWindowSum > givenSum && l < r) {
                resultMinLen = Math.min(r - l + 1, resultMinLen);
                localWindowSum -= arr[l];
                l++;
                System.out.println("resultMinLen = " + resultMinLen);
                System.out.println("localWindowSum d = " + localWindowSum);
            }
        }

        return resultMinLen;
    }

    public static Long countSubarray(int N, int K, int[] A) {
        int globalCount = 0;
        int resultMinLen = Integer.MAX_VALUE;

        int localWindowSum = 0;
        int l = 0;

        for (int r = 0; r < A.length; r++) {
            localWindowSum += A[r];

            while (l < r) {
                if (localWindowSum * K == (r - l + 1)) {
                    globalCount++;
                }
                resultMinLen = Math.min(r - l + 1, resultMinLen);
                localWindowSum -= A[l];
                l++;
            }
        }
//        System.out.println("count " + globalCount);
        return Long.valueOf(globalCount);
    }

    static long countSubarray2(int N, int K, int[] A) {
        // Write your code here
        int ans = 0;
        int dp[] = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] += A[i];
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = dp[j];
                if (i != 0) {
                    sum = dp[j] - dp[i - 1];
                }
                if (sum * K == j - i + 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
