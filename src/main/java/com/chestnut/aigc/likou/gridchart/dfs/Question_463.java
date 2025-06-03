package com.chestnut.aigc.likou.gridchart.dfs;


public class Question_463 {

    public static void main(String[] args) {
        Question_463 q = new Question_463();
        int[][] grid = new int[][]{
                {1, 0},
//                {1, 1, 1, 0},
//                {0, 1, 0, 0},
//                {1, 1, 0, 0}
        };
        int x = q.islandPerimeter(grid);
        System.out.println(x);

    }

    public int islandPerimeter(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int dfs = dfs(grid, i, j);
                    max = Math.max(max, dfs);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y) {
        int count = 0;
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            count++;
            return count;
        }
        if (grid[x][y] == -1) {
            return count;
        }
        grid[x][y] = -1;
        count += dfs(grid, x + 1, y);
        count += dfs(grid, x - 1, y);
        count += dfs(grid, x, y + 1);
        count += dfs(grid, x, y - 1);
        return count;
    }
}
