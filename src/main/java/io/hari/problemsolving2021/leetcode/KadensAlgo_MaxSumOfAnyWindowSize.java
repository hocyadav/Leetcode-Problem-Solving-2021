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
}
/**
 sum = 6
 sum2 = 7
 sum3 = 100
 */
