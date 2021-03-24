package io.hari.problemsolving2021;

import static io.hari.problemsolving2021.arrays.NextGreaterElement_usingRainWaterConcept.printArray;

/**
 * @Author Hariom Yadav
 * @create 24-03-2021
 */
public class MergeSortImpl {
    public static void main(String[] args) {
        int[] arr = {10, 90, 1, 5, 7};
        printArray(arr);
        mergeSortRec(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void mergeSortRec(int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSortRec(arr, start, mid);
        mergeSortRec(arr, mid + 1 , end);
        merge2SortedArray(arr, start, mid, end);
    }

    private static void merge2SortedArray(int[] arr, int start, int mid, int end) {
        //left len right len
        //left temp and right temp array
        //while loop and fill

        int leftLen = mid - start + 1;
        int rightLen = end - mid;

        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = arr[start + i];
        }
        for (int i = 0; i < rightLen; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }
        int l = 0, r = 0, k = start;
        while (l < leftLen && r < rightLen) {
            if (leftArr[l] < rightArr[r]) {
                arr[k++] = leftArr[l++];
            } else {
                arr[k++] = rightArr[r++];
            }
        }

        while (l < leftLen) arr[k++] = leftArr[l++];
        while (r < rightLen) arr[k++] = rightArr[r++];
    }
}
/**
 10 90 1 5 7
 1 5 7 10 90
 */
