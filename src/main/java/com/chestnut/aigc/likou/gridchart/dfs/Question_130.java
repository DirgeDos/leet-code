package com.chestnut.aigc.likou.gridchart.dfs;


import java.util.Arrays;

public class Question_130 {
    private static boolean flag = false;


    public static void main(String[] args) {
        Question_130 q = new Question_130();
/*        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };*/

        char[][] board1 = new char[][]{
                {'X', 'X', 'X'},
                {'X', 'O', 'X'},
                {'X', 'X', 'X'},
        };


        q.solve(board1);
        System.out.println(Arrays.deepToString(board1));

    }

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' || board[i][j] == '0') {
                    dfs(board, i, j);
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (flag) {
            return;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || (board[x][y] != 'O' && board[x][y] != '0')) {
            return;
        }
        if ((x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) && (board[x][y] == 'O' || board[x][y] == '0')) {
            flag = true;
            return;
        }
        board[x][y] = 'X';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

}
