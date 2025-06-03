package com.chestnut.aigc.likou.gridchart.dfs;


public class Question_2684 {
    private static boolean flag = false;


    public static void main(String[] args) {
        Question_2684 q = new Question_2684();
        int[][] grid1 = new int[][]{
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15},
        };

        int[][] grid = new int[][]{
                {3, 2, 4},
                {2, 1, 9},
                {1, 1, 7},
        };

        int[][] grid2 = new int[][]{
                {1000000, 92910, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 1033, 1034, 1035, 1036, 1037, 1038, 1039, 1040, 1041, 1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068},
                {1069, 1070, 1071, 1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085, 1086, 1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 1104, 1105, 1106, 1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118},
        };
        int x = q.maxMoves(grid2);
        System.out.println(x);

    }

    public int maxMoves(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            int x = dfs(grid, i, 0, 0) - 1;
            max = Math.max(max, x);
            flag = false;
        }
        return max;
    }

    public int dfs(int[][] grid, int row, int col, int LastValue) {
        int count = 0;
        if (col >= grid[0].length) {
            flag = true;
            return count;
        }
        if (row < 0 || row >= grid.length || col < 0 || grid[row][col] <= LastValue || flag) {
            return count;
        }

        count++;
        int i1 = dfs(grid, row - 1, col + 1, grid[row][col]);
        int i2 = dfs(grid, row, col + 1, grid[row][col]);
        int i3 = dfs(grid, row + 1, col + 1, grid[row][col]);
        count += Math.max(i1, Math.max(i2, i3));
        return count;
    }
}
