package com.chestnut.aigc.likou.dp;

public class MinimumSumOfDescentPath {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9},
        };
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        int min = 0;
        for (int i = 1; i < matrix.length; i++) {
            int layerMin = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (j > 0 && j < matrix[i].length - 1) {
                    matrix[i][j] += Math.min(Math.min(matrix[i - 1][j + 1], matrix[i - 1][j]), matrix[i - 1][j - 1]);
                } else {
                    if (j == 0) {
                        matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                    } else {
                        matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                    }
                }
                layerMin = Math.min(layerMin, matrix[i][j]);
            }
            min = layerMin;
        }
        return min;
    }
}
