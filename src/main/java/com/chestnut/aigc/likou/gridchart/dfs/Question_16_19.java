package com.chestnut.aigc.likou.gridchart.dfs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_16_19 {
    private static int count = 0;

    public static void main(String[] args) {
        Question_16_19 q = new Question_16_19();
        int[][] nums = new int[][]{
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        int[] x = q.pondSizes(nums);
        System.out.println(Arrays.toString(x));

    }

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    dfs(land, i, j);
                    list.add(count);
                    count = 0;
                }
            }
        }
        return list.stream().mapToInt(i -> i).sorted().toArray();
    }

    public void dfs(int[][] land, int x, int y) {
        if (x < 0 || x >= land.length || y < 0 || y >= land[0].length || land[x][y] != 0) {
            return;
        }
        land[x][y] = -1;
        count++;
        dfs(land, x + 1, y);
        dfs(land, x - 1, y);
        dfs(land, x, y + 1);
        dfs(land, x, y - 1);
        dfs(land, x + 1, y + 1);
        dfs(land, x - 1, y - 1);
        dfs(land, x - 1, y + 1);
        dfs(land, x + 1, y - 1);
    }


}
