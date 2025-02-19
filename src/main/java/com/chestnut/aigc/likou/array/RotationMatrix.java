package com.chestnut.aigc.likou.array;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class RotationMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        for (int i = 0; i <= matrix.length / 2 - 1; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix[0].length - 1 - j][i];
                matrix[matrix[0].length - 1 - j][i] = matrix[matrix[0].length - 1 - i][matrix[0].length - 1 - j];
                matrix[matrix[0].length - 1 - i][matrix[0].length - 1 - j] = matrix[j][matrix[0].length - 1 - i];
                matrix[j][matrix[0].length - 1 - i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

}
