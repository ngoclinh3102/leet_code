package logixtek.moitech.leetcode.practice;

public class L037 {
    /* Sudoku Solver */
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '9'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '.'},
        };
        solveSudoku(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        solve(board,0,0);
    }

    private static boolean solve(char[][] board, int row, int col) {
        if (row == board.length) return true;

        if (col == board[0].length) return solve(board, row + 1, 0);

        if (board[row][col] != '.') return solve(board, row, col + 1);

        for (char num = '1'; num <= '9'; num++) {
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board, row, col + 1)) {
                    return true;
                }
            }
        }

        board[row][col] = '.';
        return false;
    }

    private static boolean isValidPlacement(char[][] board, int row, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) return false;
            if (board[row][i] == num) return false;
            if (board[3*(row/3)+i/3][3*(col/3)+i%3] == num) return false;
        }
        return true;
    }
}


