package io.hari.problemsolving2021.tapping_rain;

import java.util.regex.Matcher;

import static io.hari.problemsolving2021.arrays.NextGreaterElement_usingRainWaterConcept.printArray;

/**
 * @Author Hariom Yadav
 * @create 27-03-2021
 */
public class TappingRainWater {
    public static void main(String[] args) {
        final int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        findWater(arr);
        findWater(new int[]{4,2,0,3,2,5});
        findWater_using1Array(arr);
    }

    private static void findWater(int[] arr) {
        int[] leftMaxHeight = new int[arr.length];
        leftMaxHeight[0] = 0;
        for (int i = 1; i < leftMaxHeight.length; i++) {
            final int prevOriginal = arr[i - 1];
            final int prevLeft = leftMaxHeight[i - 1];
            leftMaxHeight[i] = Math.max(prevOriginal, prevLeft);
        }
        printArray(leftMaxHeight);

        int[] rightMaxHeight = new int[arr.length];
        rightMaxHeight[rightMaxHeight.length - 1] = 0;
        for (int i = rightMaxHeight.length - 2; i >=0 ; i--) {
            final int prevOriginal = arr[i + 1];
            final int prevRight = rightMaxHeight[i + 1];
            rightMaxHeight[i] = Math.max(prevOriginal, prevRight);
        }
        printArray(rightMaxHeight);

        //traverse original array
        int resultWater = 0;
        for (int i = 0; i < arr.length; i++) {
            final int currMinHeightBothSide = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            final int currentDepth = arr[i];

            final int diff = currMinHeightBothSide - currentDepth;
            if (diff <= 0) continue;
            resultWater += diff;
        }
        System.out.println(resultWater);
    }

    private static void findWater_using1Array(int[] arr) {
        int[] rightMaxHeight = new int[arr.length];
        rightMaxHeight[rightMaxHeight.length - 1] = 0;
        for (int i = rightMaxHeight.length - 2; i >= 0; i--) {
            final int prevOriginal = arr[i + 1];
            final int prevRightMax = rightMaxHeight[i + 1];
            rightMaxHeight[i] = Math.max(prevOriginal, prevRightMax);
        }
        int resultWater = 0;
        int leftMaxHeight = 0;//left max array
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) leftMaxHeight = Math.max(leftMaxHeight, arr[i - 1]);//new line to calculate left max value

            final int currMinHeightBothSide = Math.min(leftMaxHeight, rightMaxHeight[i]);
            final int currentDepth = arr[i];

            final int diff = currMinHeightBothSide - currentDepth;
            if (diff <= 0) continue;
            resultWater += diff;
        }
        System.out.println("using 1 array : "+ resultWater);
    }
}
/**
 0 0 1 1 2 2 2 2 3 3 3 3
 3 3 3 3 3 3 3 2 2 2 1 0
 6
 0 4 4 4 4 4
 5 5 5 5 5 0
 9
 using 1 array : 6
 */
