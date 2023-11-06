package logixtek.moitech.leetcode.practice;

public class L329 {
    public static void main(String[] args) {
        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
        System.out.println(longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] paths = new int[m][n];

        int lip = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lip = Math.max(lip, dfs(matrix, paths, i, j, -1));
            }
        }

        return lip;
    }

    private static int dfs(int[][] matrix, int[][] paths, int i, int j, int prevValue) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prevValue) {
            return 0;
        }

        if (paths[i][j] != 0) {
            return paths[i][j];
        }

        int top = dfs(matrix, paths, i - 1, j, matrix[i][j]);
        int bot = dfs(matrix, paths, i + 1, j, matrix[i][j]);
        int left = dfs(matrix, paths, i, j - 1, matrix[i][j]);
        int right = dfs(matrix, paths, i, j + 1, matrix[i][j]);

        return paths[i][j] = Math.max(Math.max(Math.max(top, bot), left), right);
    }
}
