package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;

public class L1337 {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(kWeakestRows(array,3)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[][] weakRows = new int[mat.length][2];
        int[] kWeakestRows = new int[k];

        for (int i = 0; i < mat.length; i++) {
            int strength = countSoldiersBS(mat[i]);
            weakRows[i][0] = i;
            weakRows[i][1] = strength;
        }

        Arrays.sort(weakRows, Comparator.comparingInt(r -> r[1] * 1000 + r[0]));

        for (int i = 0; i < k; i++) {
            kWeakestRows[i] = weakRows[i][0];
        }

        return kWeakestRows;
    }

    private static int countSoldiersBS(int... row) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == 1) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
