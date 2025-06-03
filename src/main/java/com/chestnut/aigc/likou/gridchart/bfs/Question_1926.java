package com.chestnut.aigc.likou.gridchart.bfs;


import java.util.LinkedList;
import java.util.Queue;

public class Question_1926 {

    public static void main(String[] args) {
        Question_1926 q = new Question_1926();
        char[][] maze = new char[][]{
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'},
        };
        char[][] maze1 = new char[][]{
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'},
        };
        int[] entrance = new int[]{1, 0};

        int x = q.nearestExit(maze1, entrance);
        System.out.println(x);

    }

    public int nearestExit(char[][] maze, int[] entrance) {
        return bfsSearch(maze, entrance);
    }

    private int bfsSearch(char[][] maze, int[] entrance) {
        int[][] displacement = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0},
        };
        int maxStep = maze.length * maze[0].length;
        int minStep = maxStep;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int step = poll[2];
            maze[poll[0]][poll[1]] = '+';
            for (int[] dis : displacement) {
                int nextX = poll[0] + dis[0];
                int nextY = poll[1] + dis[1];
                if (nextX == -1 || nextX == maze.length || nextY == maze[0].length || nextY == -1 || maze[nextX][nextY] == '+') {
                    continue;
                }
                if (nextX == maze.length - 1 || nextX == 0 || nextY == maze[0].length - 1 || nextY == 0) {
                    minStep = Math.min(minStep, step + 1);
                }
                queue.offer(new int[]{nextX, nextY, step + 1});
                maze[nextX][nextY] = '+';
            }

        }
        return minStep == maxStep ? -1 : minStep;
    }


}
