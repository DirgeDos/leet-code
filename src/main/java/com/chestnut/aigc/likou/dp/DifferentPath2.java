package com.chestnut.aigc.likou.dp;

public class DifferentPath2 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 0}
        };
        System.out.println(uniquePathsWithObstacles(nums));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 1 && n == 1 && obstacleGrid[0][0] == 0) {
            return 1;
        }
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }



        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i > 0 && obstacleGrid[i - 1][j] != 1) {
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                }
                if (j > 0 && obstacleGrid[i][j - 1] != 1) {
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                }
            }
        }
        return Math.abs(obstacleGrid[m - 1][n - 1]);
    }
}
