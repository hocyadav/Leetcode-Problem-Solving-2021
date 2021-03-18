package io.hari.problemsolving2021.leetcode;

import java.util.*;

/**
 * @Author Hariom Yadav
 * @create 18-03-2021
 */
public class IntersectionOf2Array {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 9, 9};
        int[] arr2 = new int[]{1, 2, 9, 9};
        intersectionUsing2Set(arr1, arr2);
        intersectionOfArrayUsing2Pointer(arr1, arr2);
        intersectionOfArray_UsingBinarySearchOnSortedArray(arr1, arr2);

        intersectionOfArray_Q2_StoringAllCommonValues(arr1, arr2); // intersection-of-two-arrays-ii
    }

    /**
     * https://leetcode.com/problems/intersection-of-two-arrays-ii/
     * store all common values
     * sort both array, + 2 pointers + traverse
     */
    private static void intersectionOfArray_Q2_StoringAllCommonValues(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        List<Integer> list = new LinkedList<>();

        int p1 = 0, p2 = 0;
        while (p1 < array1.length && p2 < array2.length) {
            if (array1[p1] < array2[p2]) p1++; //1st array value less so move 1st pointer
            else if (array1[p1] > array2[p2]) p2++;
            else { //present in both array
                list.add(array1[p1]);
                p1++; p2++;
            }
        }
        System.out.println("list = " + list);
    }

    /**
     * https://leetcode.com/problems/intersection-of-two-arrays/
     * store 1st array in set1
     * store 2nd array in set2 only if present in set1
     * TN : n
     */
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

    /**
     * sort array + 2 pointer + set
     * 1. sort both arrays
     * 2. solve using 2 pointer
     * 3. traverse and if 1st array value less move 1st pointer, if 2nd array value greater then move 2nd pointer,
     * if both value same than store in set
     * TC : n log n
     */
    public static void intersectionOfArrayUsing2Pointer(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        Set<Integer> intersectionSet = new HashSet<>();

        int p1 = 0, p2 = 0;
        while (p1 < array1.length && p2 < array2.length) {
            if (array1[p1] < array2[p2]) p1++; //1st array value less so move 1st pointer
            else if (array1[p1] > array2[p2]) p2++;
            else { //present in both array
                intersectionSet.add(array1[p1]);
                p1++; p2++;
            }
        }
        System.out.println("intersectionSet = " + intersectionSet);
    }

    /**
     * Sort + Binary search + set
     *
     * sort array 2
     * traverse array1 and store in set 1
     * call Binary search for each value and if present then add to set
     * TC : n log n
     */
    public static void intersectionOfArray_UsingBinarySearchOnSortedArray(int[] array1, int[] array2) {
        Arrays.sort(array2);
        Set<Integer> set = new HashSet<>();

        for (int targetVal : array1) {
            if (binarySearch(array2, targetVal)) {//call Binary search on sorted array
                set.add(targetVal);
            }
        }
        System.out.println("using binary search  = " + set);
    }

    private static boolean binarySearch(int[] arr, int targetVal) {
        return rec(arr, targetVal, 0, arr.length - 1);
    }

    private static boolean rec(int[] arr, int targetVal, int start, int end) {
        if (start > end) return false;

        int mid = start + (end - start)/2; //or int mid = (start + end)/2;, both are same
        if (arr[mid] == targetVal) return true;

        if (targetVal < arr[mid])
            return rec(arr, targetVal, start, mid - 1);
        else
            return rec(arr, targetVal, mid + 1, end);
    }
}
/**
 set2Intersection = [1, 2, 9]
 intersectionSet = [1, 2, 9]
 using binary search  = [1, 2, 9]
 list = [1, 2, 9, 9]
 */
