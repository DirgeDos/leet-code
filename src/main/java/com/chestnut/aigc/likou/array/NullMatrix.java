package com.chestnut.aigc.likou.array;

import java.util.Arrays;

public class NullMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[] rowNull = new int[rowLength];
        int[] colNull = new int[colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if(matrix[i][j] == 0) {
                    rowNull[i] = 1;
                    colNull[j] = 1;
                }

            }
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (rowNull[i] == 1) {
                    matrix[i][j] = 0;
                }
                if (colNull[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
