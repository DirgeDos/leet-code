package com.chestnut.aigc.likou.gridchart.bfs;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Question_994 {

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
        Question_994 q = new Question_994();
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1},
        };

        int[][] grid1 = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1},
        };

        int[][] grid2 = new int[][]{
                {0},

        };

        int x = q.orangesRotting(grid1);
        System.out.println(x);

    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int totalOranges = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    totalOranges++;
                }
            }
        }

        int minute = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int step = poll[2];
            for (int[] dis : fourDirectionalDisplacement) {
                int nextX = x + dis[0];
                int nextY = y + dis[1];
                if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols) {
                    continue;
                }
                if (grid[nextX][nextY] != 1) {
                    continue;
                }
                queue.offer(new int[]{nextX, nextY, step + 1});
                grid[nextX][nextY] = 2;
                minute = Math.max(step + 1, minute);
                totalOranges--;
            }


        }
        return totalOranges == 0 ? minute : -1;

    }


}
