package logixtek.moitech.leetcode.practice.models;

public class NumMatrix {

    private final int[][] SUM_MATRIX;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        SUM_MATRIX = new int[m][n];

        SUM_MATRIX[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) SUM_MATRIX[i][0] = SUM_MATRIX[i-1][0] + matrix[i][0];
        for (int j = 1; j < n; j++) SUM_MATRIX[0][j] = SUM_MATRIX[0][j-1] + matrix[0][j];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                SUM_MATRIX[i][j] = matrix[i][j] + SUM_MATRIX[i][j-1] + SUM_MATRIX[i-1][j] - SUM_MATRIX[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int TOTAL = SUM_MATRIX[row2][col2];
        int WING1 = (row1 > 0) ? SUM_MATRIX[row1 - 1][col2] : 0;
        int WING2 = (col1 > 0) ? SUM_MATRIX[row2][col1 - 1] : 0;
        int TAIL = (row1 > 0 && col1 > 0) ? SUM_MATRIX[row1 - 1][col1 - 1] : 0;

        return TOTAL - WING1 - WING2 + TAIL;
    }

    public int getM() {
        return SUM_MATRIX.length;
    }

    public int getN() {
        return SUM_MATRIX[0].length;
    }
}
