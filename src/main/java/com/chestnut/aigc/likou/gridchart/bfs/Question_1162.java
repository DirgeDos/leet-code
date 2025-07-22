package com.chestnut.aigc.likou.gridchart.bfs;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//多源
public class Question_1162 {

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
        Question_1162 q = new Question_1162();
        int[][] grid = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1},
        };

        int[][] grid1 = new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };

        int[][] grid2 = new int[][]{
                {0},

        };

        int x = q.maxDistance1(grid1);
        System.out.println(x);

    }

    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (queue.isEmpty() || queue.size() == grid.length * grid[0].length) {
            return -1;
        }

        int[] poll = null;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];
            for (int[] dis : fourDirectionalDisplacement) {
                int nextX = nowX + dis[0];
                int nextY = nowY + dis[1];
                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || grid[nextX][nextY] != 0) {
                    continue;
                }
                grid[nextX][nextY] = grid[nowX][nowY] + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }

        return grid[poll[0]][poll[1]] - 1;
    }


    public int maxDistance1(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        if (queue.isEmpty() || queue.size() == grid.length * grid[0].length) {
            return -1;
        }

        int step = -1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];
            int dis = poll[2];

            for (int[] direction : fourDirectionalDisplacement) {
                int nextX = direction[0] + nowX;
                int nextY = direction[1] + nowY;
                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || grid[nextX][nextY] != 0) {
                    continue;
                }
                grid[nextX][nextY] = dis + 1;
                queue.offer(new int[]{nextX, nextY, dis + 1});
                step = Math.max(step, grid[nextX][nextY]);
            }
        }
        return step;
    }


}
