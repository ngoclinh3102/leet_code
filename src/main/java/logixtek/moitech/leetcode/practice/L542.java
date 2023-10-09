package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L542 {

    public static void main(String[] args) {
//        updateMatrix(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
//        updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
        printMatrix(updateMatrix(new int[][]{
                {0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
        }));
    }

    private static final int MAX_DISTANCE = 10_000;

    public static int[][] updateMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    mat[i][j] = 1 + minAbove(mat, i, j);
                }
            }
        }

        for (int i = mat.length - 1; i >= 0 ; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                mat[i][j] = Math.min(mat[i][j], 1 + minBelow(mat, i, j));
            }
        }

        return mat;
    }

    private static int minAbove(int[][] mat, int x, int y) {
        return Math.min(
                x > 0 ? mat[x-1][y] : MAX_DISTANCE,
                y > 0 ? mat[x][y-1] : MAX_DISTANCE
        );
    }

    private static int minBelow(int[][] mat, int x, int y) {
        return Math.min(
                (x + 1 < mat.length) ? mat[x+1][y] : MAX_DISTANCE,
                (y + 1 < mat[0].length) ? mat[x][y+1] : MAX_DISTANCE
        );
    }

    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) System.out.println(Arrays.toString(row));
        System.out.println("// === === === //");
    }
}
