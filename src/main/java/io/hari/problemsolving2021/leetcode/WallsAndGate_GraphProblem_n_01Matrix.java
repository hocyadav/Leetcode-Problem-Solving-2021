package io.hari.problemsolving2021.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Hariom Yadav
 * @create 17-03-2021
 */
public class WallsAndGate_GraphProblem_n_01Matrix {
    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] arr = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF},
        };
        print2DArray(arr);
//        wallsAndGate(arr);//working
        zeroOneMatrix_UsingBFSQueue2_ForWallsAndGate(arr);//working
        print2DArray(arr);
        System.out.println("---------end------------");


        int[][] arr2 = {
                {0, 0, 1},
                {0, 1, 1},
                {1, 1, 1},
        };
        print2DArray(arr2);
//        zeroOneMatrix1_usingWallsAndGate(arr2);//working using dp
////        zeroOneMatrix_UsingBFSQueue(arr2);//not working
        zeroOneMatrix_UsingBFSQueue2(arr2);//working using queue
//        print2DArray(arr2);
    }

    //same as walls and gateway. 1st change all 1 to Int Max
    private static void zeroOneMatrix1_usingWallsAndGate(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) arr[i][j] = Integer.MAX_VALUE;
            }
        }
        wallsAndGate(arr);
    }

    //1. store all 0 node in Queue + mark visited true
    //2. poll 0 from Queue and go all 4 directions i.e. node that have 1 value
    //3. update the new direction node and mark visited true
    //https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleMedium/286.html

    public static void wallsAndGate(int[][] rooms) {
        //null check
        final int r = rooms.length;
        final int c = rooms[0].length;
        boolean[][] visited = new boolean[r][c]; //to avoid loops
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rooms[i][j] == 0) dfs(rooms, i, j, 0, visited);
            }
        }
    }
    //1st time distance will come as 0
    private static void dfs(int[][] rooms, int i, int j, int distances, boolean[][] visited) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms.length) return; //out of bounds
        if (rooms[i][j] < distances) return; //current distance is less so no need to update
        if (visited[i][j] == true) return;
        if (rooms[i][j] == -1) return;//walls
        //else not wall : see below code

        rooms[i][j] = Math.min(rooms[i][j], distances);
        //recursion starts :
        visited[i][j] = true;//1
        //3
        final int newDistance = distances + 1;//1st time : 0 + 1
        dfs(rooms, i + 1, j, newDistance, visited);
        dfs(rooms, i - 1, j, newDistance, visited);
        dfs(rooms, i, j + 1, newDistance, visited);
        dfs(rooms, i, j - 1, newDistance, visited);

        visited[i][j] = false;//2
    }

    @Deprecated
    private static void zeroOneMatrix_UsingBFSQueue(int[][] arr) { //not working, coz of iterating over four directions
        Queue<int[]> qq = new LinkedList<>();
        final int r = arr.length;
        final int c = arr[0].length;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) { //1. store all 0 node in Queue + mark visited true
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0) {
                    qq.add(new int[]{i, j});//2nd value is distance from 0 ??
                    visited[i][j] = true;
                }
            }
        }
        while (!qq.isEmpty()) {
            final int[] curr = qq.poll();
            final int currRowIndex = curr[0];
            final int currColIndex = curr[1];

            for (int i = -1; i <= 1; i++) { //go 4 directions - 4 children : not working its 3 * 3 = 9 direction
                for (int j = -1; j <= 1; j++) {
                    int childRow = currRowIndex + i;
                    int childCol = currColIndex + j;

                    if (childRow < 0 || childRow >= r || childCol < 0 || childCol >= c || visited[childRow][childCol]) //invalid + visited children
                        continue;

                    visited[childRow][childCol] = true;
                    arr[childRow][childCol] = arr[currRowIndex][currColIndex] + 1;
                    qq.add(new int[]{childRow, childCol});
                }
            }
        }
    }

    //1. store all 0 node in Queue + mark visited true
    //2. poll 0 from Queue and go all 4 directions i.e. node that have 1 value
    //3. update the new direction node and mark visited true
    private static void zeroOneMatrix_UsingBFSQueue2(int[][] arr) {//working : https://leetcode.com/problems/01-matrix/
        Queue<int[]> qq = new LinkedList<>();
        final int r = arr.length;
        final int c = arr[0].length;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) { //1. store all 0 node in Queue + mark visited true
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0) {
                    qq.add(new int[]{i, j});//2nd value is distance from 0 ??
                    visited[i][j] = true;
                }
            }
        }
        int[][] fourDir = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!qq.isEmpty()) {
            final int[] curr = qq.poll();
            final int currRowIndex = curr[0];
            final int currColIndex = curr[1];

            for (int i = 0; i < fourDir.length; i++) {
                int childRow = currRowIndex + fourDir[i][0];
                int childCol = currColIndex + fourDir[i][1];
                if (childRow < 0 || childRow >= r || childCol < 0 || childCol >= c || visited[childRow][childCol]) //invalid + visited children
                    continue;
                visited[childRow][childCol] = true;
                arr[childRow][childCol] = arr[currRowIndex][currColIndex] + 1;
                qq.add(new int[]{childRow, childCol});
            }
        }
    }

    // https://www.lintcode.com/problem/walls-and-gates/
    private static void zeroOneMatrix_UsingBFSQueue2_ForWallsAndGate(int[][] arr) {//working : https://leetcode.com/problems/01-matrix/
        Queue<int[]> qq = new LinkedList<>();//store i, j
        final int r = arr.length;
        final int c = arr[0].length;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) { //1. store all 0 node in Queue + mark visited true
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0) {
                    qq.add(new int[]{i, j});//2nd value is distance from 0 ??
                    visited[i][j] = true;
                }
            }
        }
        int[][] fourDir = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!qq.isEmpty()) {
            final int[] curr = qq.poll();
            final int currRowIndex = curr[0];
            final int currColIndex = curr[1];

            for (int i = 0; i < fourDir.length; i++) {
                int childRow = currRowIndex + fourDir[i][0];
                int childCol = currColIndex + fourDir[i][1];
                if (childRow < 0 || childRow >= r || childCol < 0 || childCol >= c || visited[childRow][childCol] //invalid + visited children
                        || arr[childRow][childCol] == -1) //adding -1 condition for wall
                    continue;
                visited[childRow][childCol] = true;
                arr[childRow][childCol] = arr[currRowIndex][currColIndex] + 1;
                qq.add(new int[]{childRow, childCol});
            }
        }
    }


    private static void print2DArray(int[][] arr) {
//        Arrays.deepToString(arr); //m1
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    private static void printQueue(Queue<int[]> qq) {
        while (!qq.isEmpty()) {
            final int[] poll = qq.poll();
            System.out.println("qq.poll() = " + poll[0]+" "+poll[1]);
        }
    }
}
/**
 2147483647 -1 0 2147483647
 2147483647 2147483647 2147483647 -1
 2147483647 -1 2147483647 -1
 0 -1 2147483647 2147483647
 --------------
 3 -1 0 1
 2 2 1 -1
 1 -1 2 -1
 0 -1 3 4
 --------------
 ---------end------------
 0 0 1
 0 1 1
 1 1 1
 --------------
 0 0 1
 0 1 2
 1 2 3
 --------------
 */
