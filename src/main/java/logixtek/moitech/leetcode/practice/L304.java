package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.NumMatrix;

public class L304 {

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        var numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // 8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // 11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // 12
    }
}
