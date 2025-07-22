package com.chestnut.aigc.likou.gridchart.bfs;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//多源
public class Question_542 {

    private final int[][] fourDirectionalDisplacement = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
    };
    private final int[][] eightDirectionalDisplacement = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1}
    };

    public static void main(String[] args) {
        Question_542 q = new Question_542();
        int[][] grid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };

        int[][] grid1 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };

        int[][] grid2 = new int[][]{
                {0},

        };

        int[][] x = q.updateMatrix(grid1);
        System.out.println(Arrays.deepToString(x));

    }

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j, 0});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            int dis = point[2];
            for (int[] ints : fourDirectionalDisplacement) {
                int nextX = x + ints[0];
                int nextY = y + ints[1];
                if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) {
                    continue;
                }
                if (mat[nextX][nextY] != -1) {
                    continue;
                }
                mat[nextX][nextY] = dis + 1;
                queue.offer(new int[]{nextX, nextY, dis + 1});
            }
        }
        return mat;
    }


}
