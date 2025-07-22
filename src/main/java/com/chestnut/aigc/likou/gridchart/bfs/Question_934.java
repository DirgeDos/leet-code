package com.chestnut.aigc.likou.gridchart.bfs;


import java.util.*;

public class Question_934 {
    private static int[] disjointSetArr = new int[10099];
    private int n;

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
        Question_934 q = new Question_934();
        int[][] grid = new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1},
        };

        int[][] grid1 = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
        };
        int[][] grid2 = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 1, 0, 1, 1, 0, 0},
        };


        int x = q.shortestBridge(grid2);
        System.out.println(x);

    }

    public int find(int value) {
        if (value == disjointSetArr[value]) {
            return value;
        }
        disjointSetArr[value] = find(disjointSetArr[value]);
        return disjointSetArr[value];
    }

    public boolean isUnion(int x, int y) {
        return find(x) == find(y);
    }

    void joinSet(int x, int y) {
        int first = find(x);
        int second = find(y);
        if (first == second) {
            return;
        }
        disjointSetArr[first] = second;
    }

    public int point(int x, int y) {
        return x * n + y;
    }

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        for (int i = 0; i <= n * n; i++) disjointSetArr[i] = i;

        int row = n;
        int col = grid[0].length;

        //构建并查集
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) continue;
                for (int[] dis : fourDirectionalDisplacement) {
                    int nextX = i + dis[0];
                    int nextY = j + dis[1];
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                    if (grid[nextX][nextY] == 0) continue;
                    joinSet(point(nextX, nextY), point(i, j));
                }
            }
        }

        //构建多源队列，双向
        int firstIsland = -1;
        int secondIsland = -1;
        Queue<Integer[]> firstQueue = new LinkedList<>();
        Queue<Integer[]> secondQueue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) continue;
                int pointV = point(i, j);
                int root = find(pointV);
                if (firstIsland == -1) {
                    firstIsland = root;
                } else if (firstIsland != root && secondIsland == -1) {
                    secondIsland = root;
                }
                if (root == firstIsland) {
                    firstQueue.add(new Integer[]{i, j, 0});
                } else if (root == secondIsland) {
                    secondQueue.add(new Integer[]{i, j, 0});
                }
            }
        }

        Queue<Integer[]> queue = new LinkedList<>();
        if (firstQueue.size() > secondQueue.size()) {
            queue = secondQueue;
        } else {
            queue = firstQueue;
        }

        int base = row * col;
        int min = base;
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int step = poll[2];
            int pointV = point(x, y);
            grid[x][y] = -1;
            for (int[] dis : fourDirectionalDisplacement) {
                int nextX = x + dis[0];
                int nextY = y + dis[1];
                int nextPointV = point(nextX, nextY);
                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || grid[nextX][nextY] == -1) continue;
                if (grid[nextX][nextY] == 0) {
                    queue.add(new Integer[]{nextX, nextY, step + 1});
                    grid[nextX][nextY] = -1;
                }
                if (grid[nextX][nextY] == 1 && !isUnion(pointV, nextPointV)) {
                    min = Math.min(min, step);
                }
            }
        }

        return min == base ? -1 : min;
    }

}
