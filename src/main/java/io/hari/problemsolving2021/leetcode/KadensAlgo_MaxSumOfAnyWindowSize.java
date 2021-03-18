package io.hari.problemsolving2021.leetcode;

/**
 * @Author Hariom Yadav
 * @create 11-03-2021
 */
public class KadensAlgo_MaxSumOfAnyWindowSize {
    public static void main(String[] args) {
        final int sum = maxSumOfAnyWindowSize(new int[]{1, 2, 3, -4});//6
        System.out.println("sum = " + sum);
        final int sum2 = maxSumOfAnyWindowSize(new int[]{1, 2, 3, -4, 5, -10, -1});//7
        System.out.println("sum2 = " + sum2);
        final int sum3 = maxSumOfAnyWindowSize(new int[]{1, 2, 3, -4, 5, -10, -1, 100});//100
        System.out.println("sum3 = " + sum3);

        final int i = maxSumOfAnyWindow_UsingSlidingWindow(new int[]{1, 2, 3, -4});
        System.out.println("sum4 ~ sum= " + i);
        System.out.println("sum5 ~ sum2= " + maxSumOfAnyWindow_UsingSlidingWindow(new int[]{1, 2, 3, -4, 5, -10, -1}));
        System.out.println("sum5 ~ sum3 " + maxSumOfAnyWindow_UsingSlidingWindow(new int[]{1, 2, 3, -4, 5, -10, -1, 100}));

    }

    /** Algorithm
     Max_so_far = 0
     Current_max = 0

     For(I=0, I< len) // traverse
     1. Current_max += arr[I];
     2. If(above value < 0) set curent_max 0;
     3. If(above value > max_so_far) update max_so_far = current_max;

     Return max_so_far;
     */
    public static int maxSumOfAnyWindowSize(int[] arr) {
        int globalSum = 0;

        int localSum = 0;
        for (int val : arr) {
            localSum += val;//1
            if (localSum < 0) localSum = 0;//3 reset localSum if it is negative
            globalSum = Math.max(globalSum, localSum);//2
        }
        return globalSum;
    }

    /**
     * 1. k = 1 , take 1st value as max windows sum
     * 2. traverse and calculate localsum
     * 3. reset localsum if < 0
     * 4. update result
     */
    public static int maxSumOfAnyWindow_UsingSlidingWindow(int[] arr) {
        int result = arr[0];//1st window sum, this is k = 1 for us

        int localSum = result;
        for (int i = 1; i < arr.length; i++) {//2. start from 2nd value
            localSum += arr[i];//1. update localsum
            if (localSum < 0) localSum = 0;//2 reset localSum id < 0
            result = Math.max(result, localSum);// 3. update result
        }
        return result;
    }
}
/**
 sum = 6
 sum2 = 7
 sum3 = 100
 sum4 ~ sum= 6
 sum5 ~ sum2= 7
 sum5 ~ sum3 100
 */
