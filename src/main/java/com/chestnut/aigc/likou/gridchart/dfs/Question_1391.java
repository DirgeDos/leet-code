package com.chestnut.aigc.likou.gridchart.dfs;


public class Question_1391 {
    private static boolean flag = false;


    public static void main(String[] args) {
        Question_1391 q = new Question_1391();
        int[][] grid1 = new int[][]{
                {2, 4, 3},
                {6, 5, 2},
        };

        int[][] grid2 = new int[][]{
                {1, 2, 1},
                {1, 2, 1},
        };

        int[][] grid3 = new int[][]{
                {1, 1, 2},
        };

        int[][] grid4 = new int[][]{
                {1, 1, 1, 1, 1, 1, 3},
        };
        int[][] grid5 = new int[][]{
                {2, 6, 3},
                {6, 5, 2},
        };


        boolean i = q.hasValidPath(grid5);
        System.out.println(i);

    }

    public boolean hasValidPath(int[][] grid) {
        return dfs(grid, 0, 0, false, 0);
    }

    //上一次的方向1上 2下 3左 4右
    public boolean dfs(int[][] grid, int x, int y, boolean isSuccess, int direction) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return isSuccess;
        }
        int road = grid[x][y];
        switch (road) {
            case 1:
                if (direction == 1 || direction == 2) {
                    return false;
                }
                break;
            case 2:
                if (direction == 3 || direction == 4) {
                    return false;
                }
                break;
            case 3:
                if (direction == 2 || direction == 3) {
                    return false;
                }
                break;
            case 4:
                if (direction == 2 || direction == 4) {
                    return false;
                }
                break;
            case 5:
                if (direction == 1 || direction == 3) {
                    return false;
                }
                break;
            case 6:
                if (direction == 1 || direction == 4) {
                    return false;
                }
                break;
        }
        grid[x][y] = -1;
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return true;
        }
        switch (road) {
            case 1:
                isSuccess = dfs(grid, x, y + 1, isSuccess, 4);
                isSuccess = dfs(grid, x, y - 1, isSuccess, 3);
                break;
            case 2:
                isSuccess = dfs(grid, x + 1, y, isSuccess, 2);
                isSuccess = dfs(grid, x - 1, y, isSuccess, 1);
                break;
            case 3:
                isSuccess = dfs(grid, x, y - 1, isSuccess, 3);
                isSuccess = dfs(grid, x + 1, y, isSuccess, 2);
                break;
            case 4:
                isSuccess = dfs(grid, x, y + 1, isSuccess, 4);
                isSuccess = dfs(grid, x + 1, y, isSuccess, 2);
                break;
            case 5:
                isSuccess = dfs(grid, x, y - 1, isSuccess, 3);
                isSuccess = dfs(grid, x - 1, y, isSuccess, 1);
                break;
            case 6:
                isSuccess = dfs(grid, x, y + 1, isSuccess, 4);
                isSuccess = dfs(grid, x - 1, y, isSuccess, 1);
                break;
        }
        return isSuccess;
    }


}
