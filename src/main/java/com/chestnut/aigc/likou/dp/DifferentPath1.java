package com.chestnut.aigc.likou.dp;

public class DifferentPath1 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }

        int[][] cell = new int[m][n];
        cell[0][0] = 1;
        int maxPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cell[i][j] == 0) {
                    int num = 0;
                    if (i - 1 >= 0) {
                        num += cell[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        num += cell[i][j - 1];
                    }
                    if (num > 0) {
                        cell[i][j] = num;
                        maxPath = Math.max(maxPath, cell[i][j]);
                    }
                }
            }
        }
        return maxPath;
    }
}
