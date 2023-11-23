package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L498 {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }; // 1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int size = m * n;

        int[] zigzag = new int[size];

        int i = 0;
        int j = 0;
        int index = 0;
        char direction = 'U';

        while (index < size) {
            if (direction == 'U') {
                while (index < size && i >= 0 && j < n) {
                    zigzag[index++] = mat[i--][j++];
                }

                i++;
                direction = 'D';
                if (j == n) {
                    i++;
                    j--;
                }
            }
            else {
                while (index < size && i < m && j >= 0) {
                    zigzag[index++] = mat[i++][j--];
                }

                j++;
                direction = 'U';
                if (i == m) {
                    i--;
                    j++;
                }
            }
        }

        return zigzag;
    }
}
