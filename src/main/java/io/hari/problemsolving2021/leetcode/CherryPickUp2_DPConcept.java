package io.hari.problemsolving2021.leetcode;

/**
 * @Author Hariom Yadav
 * @create 12-03-2021
 */
public class CherryPickUp2_DPConcept {
    static Integer[][][] dp;

    public static void main(String[] args) {
//        [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
        int[][] grid = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };
        printArray(grid);
        int r = grid.length;
        int c = grid[0].length;
        dp = new Integer[r][c][c];
        final Integer cherryPickUp2Robot = cherryPickUp2Robot(grid, 0, 0, c - 1);
        System.out.println("cherryPickUp2Robot = " + cherryPickUp2Robot);

        final int dfs = dfs2(grid, 0, 0, c - 1);
        System.out.println("dfs = " + dfs);
    }

    //1. each dp box will store = current value + next best path sum //Z
    //now think about small problem : take both robot to down of matrix and write validations //A
    //when both robot out of boundary dont do anything return//B
    //when we already have value then also return memoization value//C
    public static Integer cherryPickUp2Robot(int[][] grid, int r, int c1, int c2) {
        //B
        if (r == grid.length) return 0;
        //C
        if (dp[r][c1][c2] != null) return dp[r][c1][c2];
        //A
        int currentSum;
        if (c1 == c2) {
            currentSum = grid[r][c1];
        } else {
            currentSum = grid[r][c1] + grid[r][c2];
        }

        //Z
        int nextBestSum = 0;
        for (int i = -1; i < 1; i++) {
            for (int j = -1; j < 1; j++) {
                int nextCol1 = i + c1;
                int nextCol2 = i + c2;
                if (nextCol1 >= 0 && nextCol1 < grid[0].length && nextCol2 >=0 && nextCol2 < grid[0].length) {
                    int t = cherryPickUp2Robot(grid, r + 1, nextCol1, nextCol2);
                    System.out.println("t1 = " + t);
                    nextBestSum = Math.max(nextBestSum, t);
                }
            }
        }
        dp[r][c1][c2] = currentSum + nextBestSum;
        return dp[r][c1][c2];
    }
    private static int dfs2(int[][] grid, int r, int c1, int c2) {
        int m = grid.length;
        int n = grid[0].length;

        if (r == m) return 0;// out of bound path
        if (dp[r][c1][c2] != null) return dp[r][c1][c2]; // already present, memo

        //find current sum + next sum -> store in dp array and return
        int currSum = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        int nextPathMaxSum = 0; //max from total 3*3 = 9 paths
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nextCol1 = c1 + i;//next col for robot 1
                int nextCol2 = c2 + j;//next col for robot 2
                if (nextCol1 >=0 && nextCol1 < n && nextCol2 >= 0 && nextCol2 < n) {
                    int t = dfs2(grid, r + 1, nextCol1, nextCol2);
                    System.out.println("t = " + t);
                    nextPathMaxSum = Math.max(nextPathMaxSum, t);
                }
            }
        }
        dp[r][c1][c2] = currSum + nextPathMaxSum;
        return dp[r][c1][c2];
    }

    private static void printArray(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
