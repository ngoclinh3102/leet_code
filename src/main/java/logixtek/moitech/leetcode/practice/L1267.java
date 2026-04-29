package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

/**
 * @author ngoclinh
 */
public class L1267 {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowSum[i] > 1 || colSum[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        L1267 instance = new L1267();
        int[][] grid = new int[][]{
                {1,1,0,0},
                {0,0,1,0},
                {1,0,1,0},
                {0,0,1,1},
                {0,0,0,1},
        };
        System.out.println(instance.countServers(grid));
    }
}
