package com.chestnut.aigc.likou.gridchart.dfs;


public class Question_1020 {
    private static boolean flag = false;


    public static void main(String[] args) {
        Question_1020 q = new Question_1020();
        int[][] grid = new int[][]{
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
        };
        int x = q.numEnclaves(grid);
        System.out.println(x);

    }

    public int numEnclaves(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int dfs = dfs(grid, i, j);
                    max += dfs;
                    flag = false;
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y) {
        int count = 0;
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return count;
        }
        //在边界
        if (grid[x][y] == 1 && (x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1)) {
            flag = true;
        }
        count++;
        grid[x][y] = 0;
        count += dfs(grid, x + 1, y);
        count += dfs(grid, x - 1, y);
        count += dfs(grid, x, y + 1);
        count += dfs(grid, x, y - 1);
        if (flag) {
            count = 0;
        }
        return count;
    }
}
