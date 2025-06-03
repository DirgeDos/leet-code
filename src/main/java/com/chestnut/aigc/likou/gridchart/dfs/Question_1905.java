package com.chestnut.aigc.likou.gridchart.dfs;


public class Question_1905 {
    private static boolean flag = false;


    public static void main(String[] args) {
        Question_1905 q = new Question_1905();
        int[][] grid1 = new int[][]{
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
        };

        int[][] grid2 = new int[][]{
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
        };

        int[][] grid3 = new int[][]{
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
        };

        int[][] grid4 = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1},
        };


        int i = q.countSubIslands(grid1, grid2);
        System.out.println(i);

    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    boolean isNotIsland = dfs(grid1, grid2, i, j, false);
                    if (!isNotIsland) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int x, int y, boolean isNotIsland) {
        if (x < 0 || y < 0 || x >= grid1.length || y >= grid1[0].length || grid2[x][y] != 1) {
            return isNotIsland;
        }
        if (grid1[x][y] != 1) {
            isNotIsland = true;
        }
        grid2[x][y] = 2;
        isNotIsland = dfs(grid1, grid2, x + 1, y, isNotIsland);
        isNotIsland = dfs(grid1, grid2, x - 1, y, isNotIsland);
        isNotIsland = dfs(grid1, grid2, x, y + 1, isNotIsland);
        isNotIsland = dfs(grid1, grid2, x, y - 1, isNotIsland);
        return isNotIsland;
    }


}
