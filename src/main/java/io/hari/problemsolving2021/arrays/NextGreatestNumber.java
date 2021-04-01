package io.hari.problemsolving2021.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.hari.problemsolving2021.arrays.NextGreaterElement_usingRainWaterConcept.printArray;

/**
 * @Author Hariom Yadav
 * @create 01-04-2021
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreatestNumber {
    public static void main(String[] args) {
        //distinct num
        final int[] arr1 = {4, 1, 2};
        final int[] arr2 = {1, 3, 4, 2};
        printArray(arr1);
        printArray(arr2);

        nextGreatestNum(arr1, arr2);
        nextGreatestNum(new int[]{2, 4}, new int[]{1, 2, 3, 4});
    }

    //not working for large array size
    private static void nextGreatestNum(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        System.out.println("map = " + map);

        int[] right = new int[arr2.length];
        right[0] = 0;
        for (int i = right.length - 2; i >= 0; i--) {
            final int act = arr2[i + 1];
            final int rAct = right[i + 1];
            if (arr2[i] < act) {
                right[i] = act;
                continue;
            }
            right[i] = Math.max(act, rAct);
        }
        printArray(right);
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            final int curr = arr1[i];
            final Integer val = map.get(curr);
            final int right_ = right[val];
            if (right_ >= arr1[i]) {
                result[i] = right_;
                continue;
            }
            result[i] = -1;

        }
        printArray(result);
        System.out.println();
    }
}

/**
 4 1 2
 1 3 4 2
 map = {1=0, 3=1, 4=2, 2=3}
 3 4 2 0
 -1 3 -1

 map = {1=0, 2=1, 3=2, 4=3}
 2 3 4 0
 3 -1
 */
