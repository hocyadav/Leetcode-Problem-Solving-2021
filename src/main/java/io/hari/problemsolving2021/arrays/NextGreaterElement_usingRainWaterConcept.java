package io.hari.problemsolving2021.arrays;

/**
 * @Author Hariom Yadav
 * @create 23-03-2021
 */
public class NextGreaterElement_usingRainWaterConcept {
    public static void main(String[] args) {
        findNextGreaterForAllElement(new int[]{4, 5, 2, 25});
        findNextGreaterForAllElement(new int[]{13, 7, 6, 12});
        findNextGreaterForAllElement(new int[]{11, 13, 21, 3});
    }

    /**
     * Approach : using rain water concept
     * TC: n, SC : n (right array)
     * @param arr
     */
    private static void findNextGreaterForAllElement(int[] arr) {
        int[] right = new int[arr.length];
        right[right.length - 1] = -1;
        printArray(arr);
        printArray(right);

        for (int i = right.length - 2; i >= 0; i--) {//traverse over right array , but comparing in if block of arr values
            final int currArrvalue = arr[i];
//            System.out.println(currArrvalue);
//            System.out.println(arr[i+1]);
//            System.out.println(right[i+1]+"\n");

            if (currArrvalue <= arr[i + 1]) {
                right[i] = arr[i + 1];
            } else if (currArrvalue <= right[i + 1]){
                right[i] = right[i + 1];
            } else {
                right[i] = -1;
            }
        }
        printArray(right);
        System.out.println();
    }

    private static void printArray(int[] right) {
        for (int i = 0; i < right.length; i++) {
            System.out.print(right[i]+" ");
        }
        System.out.println();
    }
}
/**
 4 5 2 25
 0 0 0 -1
 5 25 25 -1

 13 7 6 12
 0 0 0 -1
 -1 12 12 -1

 11 13 21 3
 0 0 0 -1
 13 21 -1 -1
 */
