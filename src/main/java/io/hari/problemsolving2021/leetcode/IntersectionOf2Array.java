package io.hari.problemsolving2021.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Hariom Yadav
 * @create 18-03-2021
 */
public class IntersectionOf2Array {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{1, 2};
        intersectionUsing2Set(arr1, arr2);
    }

    public static void intersectionUsing2Set(int[] array1, int[] array2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2Intersection = new HashSet<>();

        for (int val : array1) //store 1st array in set1
            set1.add(val);

        for (int val : array2) { //store 2nd array in set1 2 only if present in set1
            if (set1.contains(val)) {
                set2Intersection.add(val);
            }
        }
        System.out.println("set2Intersection = " + set2Intersection);

        //optional : store set1 value in array
        int[] result = new int[set2Intersection.size()];
        int i = 0;
        for (int s : set2Intersection){
            result[i++] = s;
        }
    }
}
/**
 set2Intersection = [1, 2]
 */
