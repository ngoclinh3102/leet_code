package logixtek.moitech.leetcode.practice;

public class L221 {

    public static void main(String[] args) {
    }

    public static int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxEdge = 0;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    maxEdge = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] != 0) {
                    int minAbove = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    dp[i][j] = minAbove + 1;
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
        }

        return maxEdge * maxEdge;
    }
}
