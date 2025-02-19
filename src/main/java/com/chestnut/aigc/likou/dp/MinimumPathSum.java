package com.chestnut.aigc.likou.dp;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        System.out.println(minPathSum(nums));
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j > 0 && i > 0) {
                    grid[i][j] = Math.min(grid[i][j] + grid[i][j - 1], grid[i][j] + grid[i - 1][j]);
                } else {
                    if (i > 0) {
                        grid[i][j] += grid[i - 1][j];
                    }
                    if (j > 0) {
                        grid[i][j] += grid[i][j - 1];
                    }
                }

            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
