package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L052 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(12));

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

    private static int answer;

    public static int solveNQueens(int n) {
        answer = 0;
        int[] board = new int[n];
        Arrays.fill(board, -1);

        solve(board, 0);

        return answer;
    }

    private static void solve(int[] board, int row) {
        if (row == board.length) {
            answer++;
            return;
        }

        for (int col = 0; col < board.length; col++) {
            board[row] = col;
            if (isValidQueen(board, row)) {
                solve(board, row + 1);
            }
        }
        board[row] = -1;
    }

    private static boolean isValidQueen(int[] board, int row) {
        int k = row - 1;
        while (k >= 0) {
            if ((board[k] == board[row]) || (row - k == Math.abs(board[row] - board[k]))) {
                return false;
            }
            k--;
        }
        return true;
    }
}
