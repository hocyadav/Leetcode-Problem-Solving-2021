package io.hari.problemsolving2021.queue_n_heap;

/**
 * @Author Hariom Yadav
 * @create 22-03-2021
 */
public class MaxHeapImpl {
    public static void main(String[] args) {
        int[] arr = {12, 13, 1, 4, 8, 5};
        printArray(arr);//before heapify
        buildMaxHeap(arr);
        printArray(arr);
        int length = arr.length;
        System.out.println("maxDataFromhHeap = " + getMaxDataFromhHeap(arr, length));
        printArray(arr);
        length = length - 1;
        System.out.println("maxDataFromhHeap = " + getMaxDataFromhHeap(arr, length));
        printArray(arr);
    }

    private static int getMaxDataFromhHeap(int[] arr, int len) {
        //return 1st value from array
        //swap with last one and then call heapify for 1st node
        final int maxData = arr[0];//1
        swap(arr, 0, len - 1);
        heapify(arr, 0, len - 1);
        return maxData;//2
    }

    private static void swap(int[] arr, int i, int i1) {
        int t = arr[i];
        arr[i] = arr[i1];
        arr[i1] = t;
    }

    private static void buildMaxHeap(int[] arr) {
        int mid = arr.length/2;
        for (int i = mid; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int largest = i;
        int left = i*2 + 1;
        int right = i*2 + 2;

        //find largest index
        if (left < len && arr[left] > arr[largest]) largest = left;
        if (right < left && arr[right] > arr[largest]) largest = right;

        if (i != largest) {
            //swap
            //call heapify
            int t = arr[largest];
            arr[largest] = arr[i];
            arr[i] = t;
            heapify(arr, largest, len);
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
/**
 Array : 12 13 1 4 8 5
 Array : 13 12 5 4 8 1
 maxDataFromhHeap = 13
 Array : 12 4 5 1 8 13
 maxDataFromhHeap = 12
 Array : 8 4 5 1 12 13
 */
