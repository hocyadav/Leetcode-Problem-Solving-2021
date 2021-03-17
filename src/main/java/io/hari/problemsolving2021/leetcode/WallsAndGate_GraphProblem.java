package io.hari.problemsolving2021.leetcode;

/**
 * @Author Hariom Yadav
 * @create 17-03-2021
 */
public class WallsAndGate_GraphProblem {
    public static void main(String[] args) {
        final int INF = Integer.MAX_VALUE;
        int[][] arr = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF},
        };
        print2DArray(arr);
        wallsAndGate(arr);
        print2DArray(arr);

    }

    private static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    public static void wallsAndGate(int[][] rooms) {
        //null check
        final int r = rooms.length;
        final int c = rooms[0].length;
        boolean[][] visited = new boolean[r][c];
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

 */
