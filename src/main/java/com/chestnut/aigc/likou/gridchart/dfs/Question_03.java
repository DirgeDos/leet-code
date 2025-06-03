package com.chestnut.aigc.likou.gridchart.dfs;


public class Question_03 {

    public static void main(String[] args) {
        Question_03 q = new Question_03();
        String[] grid = new String[]{"11111100000", "21243101111", "21224101221", "11111101111"};
        int x = q.largestArea(grid);
        System.out.println(x);

    }

    public int largestArea(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        char[][] array = new char[n][m];
        for (int i = 0; i < grid.length; i++) {
            array[i] = grid[i].toCharArray();
        }
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != '0' && array[i][j] != 'f') {
                    int count = dfs(array, i, j, array[i][j]);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    public int dfs(char[][] grid, int x, int y, char currency) {
        int c = 0;
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return -20000;
        }
        if (grid[x][y] != currency || grid[x][y] == 'f') {
            return c;
        }
        c++;
        grid[x][y] = 'f';
        c += dfs(grid, x + 1, y, currency);
        c += dfs(grid, x - 1, y, currency);
        c += dfs(grid, x, y + 1, currency);
        c += dfs(grid, x, y - 1, currency);
        return c;
    }


}
