package com.chestnut.aigc.likou.gridchart.bfs;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Question_1765 {

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
        Question_1765 q = new Question_1765();
        int[][] isWater = new int[][]{
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 0},
        };

        int[][] isWater1 = new int[][]{
                {0, 1},
                {0, 0},
        };


        int[][] x = q.highestPeak(isWater1);
        System.out.println(Arrays.deepToString(x));

    }

    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> queue = new LinkedList<>();
        int row = isWater.length;
        int col = isWater[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                    isWater[i][j] = 0;
                } else {
                    isWater[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int high = poll[2];
            for (int[] dis : fourDirectionalDisplacement) {
                int nextX = x + dis[0];
                int nextY = y + dis[1];
                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                    continue;
                }
                if (isWater[nextX][nextY] >= 0) {
                    continue;
                }
                queue.offer(new int[]{nextX, nextY, high + 1});
                isWater[nextX][nextY] = high + 1;

            }
        }
        return isWater;
    }


}
