package com.chestnut.aigc.likou.gridchart.dfs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_417_f {
    private static boolean flag = false;


    public static void main(String[] args) {
        Question_417_f q = new Question_417_f();
        int[][] grid1 = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4},
        };

        int[][] grid2 = new int[][]{
                {2, 1},
                {1, 2},
        };

        int[][] grid3 = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5},
        };

        int[][] grid4 = new int[][]{
                {1, 1, 1, 1, 1, 1, 3},
        };
        int[][] grid5 = new int[][]{
                {2, 6, 3},
                {6, 5, 2},
        };


        List<List<Integer>> lists = q.hasValidPath(grid1);
        System.out.println(lists);

    }

    public List<List<Integer>> hasValidPath(int[][] heights) {
        int[][] h1 = new int[heights.length][heights[0].length];
        int[][] h2 = new int[heights.length][heights[0].length];
        h1 = heights;
        h2 = heights;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                boolean b1 = dfs(h1, i, j, false, -1, 1);
                boolean b2 = dfs(h2, i, j, false, -1, 2);
                if (b1 && b2) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }


    //1为左上  2为右下
    public boolean dfs(int[][] grid, int x, int y, boolean isSuccess, int lastValue, int direction) {
        if (isSuccess) {
            return isSuccess;
        }
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != -1) {
            return isSuccess;
        }
        switch (direction) {
            case 1:
                if (x == 0 || y == 0) {
                    return true;
                }
                break;
            case 2:
                if (x == grid.length - 1 || y == grid[0].length - 1) {
                    return true;
                }
                break;
        }
        if (lastValue != -1 && lastValue < grid[x][y]) {
            return false;
        }
        int height = grid[x][y];
        grid[x][y] = -1;
        isSuccess = dfs(grid, x - 1, y, isSuccess, height, direction);
        isSuccess = dfs(grid, x, y - 1, isSuccess, height, direction);
        isSuccess = dfs(grid, x, y + 1, isSuccess, height, direction);
        isSuccess = dfs(grid, x + 1, y, isSuccess, height, direction);
        return isSuccess;
    }


}
