package io.hari.problemsolving2021.leetcode.contest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Contest5thSep2021 {

    @Test
    public void foo() {
        System.out.println("quadruplets = " + countQuadruplets(new int[]{1, 2, 3, 6}));
        System.out.println("quadruplets = " + countQuadruplets(new int[]{3, 3, 6, 4, 5}));
        System.out.println("quadruplets = " + countQuadruplets(new int[]{1, 1, 1, 3, 5}));
    }

    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int sec = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int third = nums[k];
                    int total = first + sec + third;
                    for (int l = k + 1; l < nums.length; l++) {
                        if (total == nums[l]) {
                            count++;
                        }
                    }

                }
            }
        }
        return count;
    }

    @Test
    public void foo2(){
        System.out.println("weakCharacters = " + numberOfWeakCharacters(new int[][]{{5,5},{6,3},{3,6}}));
        System.out.println("weakCharacters = " + numberOfWeakCharacters(new int[][]{{2,2},{3,3}}));
        System.out.println("weakCharacters = " + numberOfWeakCharacters(new int[][]{{1,5},{10,4},{4,3}}));
        System.out.println("weakCharacters = " + numberOfWeakCharacters(new int[][]{
                {7,7},
                {1,2},
                {9,7},
                {7,3},
                {3,10},
                {9,8},
                {8,10},
                {4,3},
                {1,5},
                {1,5}}));//[[7,7],[1,2],[9,7],[7,3],[3,10],[9,8],[8,10],[4,3],[1,5],[1,5]]
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Set<String> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < properties.length; i++) {
            int[] first = properties[i];
            for (int j = 0; j < properties.length; j++) {
                int[] sec = properties[j];
                if (isWeak(first, sec) && !visited.contains(first +"#" + sec)) {
                    count++;
                    visited.add(first + "#" +sec);
                }
            }
        }
        return count;
    }

    private boolean isWeak(int[] first, int[] sec) {
        return (first[0] < sec[0] && first[1] < sec[1]) ? true : false;
    }
}
