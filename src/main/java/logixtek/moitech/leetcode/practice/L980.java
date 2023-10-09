package logixtek.moitech.leetcode.practice;

public class L980 {

    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}})); // 4
        System.out.println(uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}})); // 2
    }

    private static int ANS;

    public static int uniquePathsIII(int[][] grid) {
        ANS = 0;

        int x = -1;
        int y = -1;
        int pathLength = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    pathLength++;
                }
                else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        grid[x][y] = -1;
        find(grid, pathLength, x, y, 0);
        return ANS;
    }

    private static void find(int[][] grid, int pathLength, int x, int y, int passed) {
        boolean isNearEndPoint = (x > 0 && grid[x - 1][y] == 2) || (x + 1 < grid.length && grid[x + 1][y] == 2)
                                || (y > 0 && grid[x][y - 1] == 2) || (y + 1 < grid[0].length && grid[x][y + 1] == 2);

        if (passed == pathLength && isNearEndPoint) {
            ANS++;
            return;
        }

        if (x > 0 && grid[x-1][y] == 0) {
            grid[x-1][y] = -1;
            find(grid, pathLength, x - 1, y, passed + 1);
            grid[x-1][y] = 0;
        }
        if (x + 1 < grid.length && grid[x+1][y] == 0) {
            grid[x+1][y] = -1;
            find(grid, pathLength, x + 1, y, passed + 1);
            grid[x+1][y] = 0;
        }
        if (y > 0 && grid[x][y-1] == 0) {
            grid[x][y-1] = -1;
            find(grid, pathLength, x, y - 1, passed + 1);
            grid[x][y-1] = 0;
        }
        if (y + 1 < grid[0].length && grid[x][y+1] == 0) {
            grid[x][y+1] = -1;
            find(grid, pathLength, x, y + 1, passed + 1);
            grid[x][y+1] = 0;
        }
    }
}
