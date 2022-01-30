package io.hari.problemsolving2021.leetcode.contest;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-278/problems/all-divisions-with-the-highest-score-of-a-binary-array/
public class AllDivisions {

    @Test
    public void foo() {
        List<Integer> list = maxScoreIndices(new int[]{0, 0, 1, 0});
        System.out.println("list = " + list);
    }

    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> list = new LinkedList();

        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {//1st index
                if (nums[i] == 0) left[0] = 1;
                else left[0] = 0;
            } else if (nums[i] == 0) //other index
            {
                int i1 = left[i - 1] + 1;
                left[i] = i1;
            } else {
                left[i] = left[i - 1];
            }
        }

        int[] right = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {//1st index
                if (nums[i] == 1) right[0] = 1;
                else right[0] = 0;
            } else if (nums[i] == 1) //other index
            {
                int i1 = right[i + 1] + 1;
                right[i] = i1;
            } else {
                right[i] = right[i + 1];
            }
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int maxVal = Integer.MIN_VALUE;
        int sum = 0;

        int divIndex = 0;
        list.add(divIndex++);

        for (int i = 0; i < nums.length; i++) {
            //greater : delete list + add new data
            //smaller : update to old data
            if (i < nums.length - 1) sum = left[i] + right[i + 1];
            else sum = left[i];

            if (sum > maxVal) {
                list.clear();
                list.add(divIndex++);
                maxVal = sum;
            } else if (sum == maxVal){
                list.add(divIndex++);
            } else divIndex++;

        }
        return list;
    }
}
