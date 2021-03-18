package io.hari.problemsolving2021.matrix;

import java.util.Arrays;

/**
 * @Author Hariom Yadav
 * @create 18-03-2021
 * https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class LargestSquareMatrixOfAll1 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,  1,  1,  0},
                {1 , 1,  1,  1},
                {0 , 1,  1,  1},
                {0 , 1,  1,  1},
        };
        printArrays(matrix);
        squareMatrixOfAll1(matrix);
    }

    /**
     * 1. db[i][j] : store the size of max square matrix, and i j is the right most original matrix index
     * 2. 1st row & col store same
     * 3. traverse dp array
     * 4. if matrix[][] == 0 then dp[][] = 0
     * 5. else dp = min(top 3 neighbors) + 1
     *
     * 6. traverse dp array and find max value
     */
    public static void squareMatrixOfAll1(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];

        for (int i = 0; i < r; i++) {//1st column
            dp[i][0] = matrix[i][0];
        }
        for (int i = 0; i < c; i++) {//1st row
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) dp[i][j] = 0;
                else {
                    final int neighborsMin = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                    dp[i][j] = neighborsMin + 1;
                }
            }
        }
        //optional find minimum of dp value
        System.out.println("print dp array ");
        printArrays(dp);

        //optional : traverse and find maximum value + index
        int max = Integer.MIN_VALUE;
        int index1 = 0, index2 = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    index1 = i;
                    index2 = j;
                }
            }
        }
        //optional : print largest square matrix : going up
        for (int k = index1; k > index1 - max; k--) {
            for (int l = index2; l > index2 - max; l--) {
                System.out.print(matrix[k][l]+" ");
            }
            System.out.println();
        }
    }

    public static void printArrays(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
}
/**
 0 1 1 0
 1 1 1 1
 0 1 1 1
 0 1 1 1
 ---------------------
 print dp array
 0 1 1 0
 1 1 2 1
 0 1 2 2
 0 1 2 3
 ---------------------
 1 1 1
 1 1 1
 1 1 1
 */
