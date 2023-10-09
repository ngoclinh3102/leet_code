package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.NumMatrix;

public class L1292 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 3, 2, 4, 3, 2},
                {1, 1, 3, 2, 4, 3, 2},
                {1, 1, 3, 2, 4, 3, 2},
        };
        int[][] matrix2 = {
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
        };
        int[][] matrix3 = {
                {18,70},
                {61,1},
                {25,28},
                {14,40},
                {11,96},
                {97,96},
                {63,45},
        };
        System.out.println(maxSideLength(matrix, 4)); // 2
        System.out.println(maxSideLength(matrix2, 1)); // 0
        System.out.println(maxSideLength(matrix3, 40184)); // 2
    }

    public static int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        var sumMatrix = new NumMatrix(mat);

        int left = 0;
        int right = Math.min(m,n);

        while (left < right) {
            int target = (left + right + 1) / 2;
            if (checkExistSquare(sumMatrix, target, threshold)) {
                left = target;
            }
            else {
                right = target - 1;
            }
        }

        return left;
    }

    private static boolean checkExistSquare(NumMatrix sumMatrix, int sideLength, int threshold) {
        for (int row = 0; row + sideLength <= sumMatrix.getM(); row++) {
            for (int col = 0; col + sideLength <= sumMatrix.getN(); col++) {
                int sumSquare = sumMatrix.sumRegion(row, col, row + sideLength - 1, col + sideLength - 1);
                if (sumSquare <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
