package io.hari.problemsolving2021.tapping_rain;

/**
 * @Author Hariom Yadav
 * @create 27-03-2021
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        mostWaterArea(arr);
    }

    /**
     * find length - min of left and right
     * find breadth
     * find area + update max
     * update pointer with smaller height
     */
    private static void mostWaterArea(int[] arr) {
        int p1 = 0, p2 = arr.length - 1;

        int maxArea = 0;
        while (p1 < p2) {
            int l = Math.min(arr[p1], arr[p2]);
            int b = p2 - p1;
            int area = l * b;
            maxArea = Math.max(maxArea, area);

            if (arr[p1] < arr[p2]) p1++;
            else p2--;
        }
        System.out.println(maxArea);
    }
}
