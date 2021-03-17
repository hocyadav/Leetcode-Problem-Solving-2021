package io.hari.problemsolving2021.leetcode;

/**
 * @Author Hariom Yadav
 * @create 17-03-2021
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printMatrix(mat);
        printMatrix(mat);
        swapUpsideDown(mat);
        printMatrix(mat);
        swapSymmetricWiseDiagonalWise(mat);
        printMatrix(mat);
    }

    /**
     * Approach : Use simple swap logic, take single row as single value
     */
    private static void swapUpsideDown(int[][] mat) {
        int p1 = 0, p2 = mat.length - 1;
        while (p1 < p2) {
            int[] t = mat[p1];//single row will become one value
            mat[p1] = mat[p2];
            mat[p2] = t;
            p1++; p2--;
        }
    }

    private static void swapSymmetricWiseDiagonalWise(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println("i = " + i);
            for (int j = i + 1; j < mat[i].length; j++) {
//                System.out.println("j = " + j);
                System.out.println("swapping "+i +" "+j);
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
    }

    private static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

}
/**
 1 2 3
 4 5 6
 7 8 9
 -------------
 1 2 3
 4 5 6
 7 8 9
 -------------
 7 8 9
 4 5 6
 1 2 3
 -------------
 i = 0
 swapping 0 1
 swapping 0 2
 i = 1
 swapping 1 2
 i = 2
 7 4 1
 8 5 2
 9 6 3
 -------------
 *
 */
