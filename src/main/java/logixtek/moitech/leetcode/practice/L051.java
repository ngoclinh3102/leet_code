package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class L051 {

    public static void main(String[] args) {
        var list = solveNQueens(15);
        System.out.println(list.size());

//        for (var board : list) {
//            for (var row : board) {
//                for (var ch : row.toCharArray()) {
//                    System.out.printf("%3c", ch);
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
    }

    private static List<List<String>> answer;

    public static List<List<String>> solveNQueens(int n) {
        answer = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0);

        return answer;
    }

    private static void solve(char[][] board, int row) {
        if (row == board.length) {
            List<String> subList = new ArrayList<>();
            for (char[] chs : board) {
                subList.add(String.valueOf(chs));
            }
            answer.add(subList);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValidQueen(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValidQueen(char[][] board, int row, int col) {
        int i = 1;
        while (row - i >= 0 && col - i >= 0) {
            if (board[row - i][col - i] == 'Q') {
                return false;
            }
            i++;
        }

        i = 1;
        while (row - i >= 0 && col + i < board.length) {
            if (board[row - i][col + i] == 'Q') {
                return false;
            }
            i++;
        }

        i = 1;
        while (row - i >= 0) {
            if (board[row - i][col] == 'Q') {
                return false;
            }
            i++;
        }

        return true;
    }
}
