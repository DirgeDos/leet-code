package com.chestnut.aigc.likou.gridchart.bfs;


import java.util.LinkedList;
import java.util.Queue;

public class Question_1091 {

    public static void main(String[] args) {
        Question_1091 q = new Question_1091();
        int[][] grid = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
        };

        int[][] grid1 = new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
        };

        int[][] grid2 = new int[][]{
                {0},

        };

        int x = q.shortestPathBinaryMatrix(grid2);
        System.out.println(x);

    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        return bfsSearch(grid);
    }

    private int bfsSearch(int[][] grid) {
        int[][] fourDirectionalDisplacement = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0},
        };
        int[][] eightDirectionalDisplacement = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0},
                {-1, -1},
                {-1, 1},
                {1, -1},
                {1, 1}
        };

        if (grid[0][0] == 1) {
            return -1;
        }
        if (grid[0][0] == 0 && grid.length == 1 && grid[0].length == 1) {
            return 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int step = poll[2];
            grid[poll[0]][poll[1]] = 1;
            for (int[] dis : eightDirectionalDisplacement) {
                int nextX = x + dis[0];
                int nextY = y + dis[1];
                if (nextX == -1 || nextX == grid.length || nextY == grid[0].length || nextY == -1 || grid[nextX][nextY] != 0) {
                    continue;
                }
                if (nextX == grid.length - 1 && nextY == grid[0].length - 1) {
                    return step + 1;
                }
                queue.offer(new int[]{nextX, nextY, step + 1});
                grid[nextX][nextY] = 1;
            }

        }
        return -1;
    }


}
