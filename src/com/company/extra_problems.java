package com.company;
import java.util.*;

public class extra_problems {
    /*
        Problem: https://leetcode.com/problems/surrounded-regions/
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i > board.length - 1 || i < 0 || j > board[0].length - 1 || j < 0 || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'E';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
