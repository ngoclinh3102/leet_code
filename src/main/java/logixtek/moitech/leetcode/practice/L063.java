package logixtek.moitech.leetcode.practice;

public class L063 {

    hello
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}})); // 2
        System.out.println(uniquePathsWithObstacles(new int[][]{{1}})); // 0
        System.out.println(uniquePathsWithObstacles(new int[][]{{0}})); // 1
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,1},{0,0}})); // 1
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        obstacleGrid[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < m; i++) obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i-1][0];
        for (int j = 1; j < n; j++) obstacleGrid[0][j] = obstacleGrid[0][j] == 1 ? 0 : obstacleGrid[0][j-1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }

        return obstacleGrid[m-1][n-1];
    }
}
