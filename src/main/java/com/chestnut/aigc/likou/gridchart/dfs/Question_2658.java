package com.chestnut.aigc.likou.gridchart.dfs;


public class Question_2658 {

    public static void main(String[] args) {
        Question_2658 q = new Question_2658();
        int[][] grid = new int[][]{
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}
        };
        int x = q.findMaxFish(grid);
        System.out.println(x);

    }

    public int findMaxFish(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    int dfs = dfs(grid, i, j);
                    max = Math.max(max, dfs);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y) {
        int count = 0;
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 1) {
            return count;
        }
        count += grid[x][y];
        grid[x][y] = 0;
        count += dfs(grid, x + 1, y);
        count += dfs(grid, x - 1, y);
        count += dfs(grid, x, y + 1);
        count += dfs(grid, x, y - 1);
        return count;
    }
}
