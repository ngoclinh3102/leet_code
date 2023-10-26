package logixtek.moitech.leetcode.practice;

public class L174 {
    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }

    public static  int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        dungeon[m-1][n-1] = Math.max(0, - dungeon[m - 1][n - 1]);
        for (int i = m-2; i >= 0; i--) {
            dungeon[i][n-1] = Math.max(0, dungeon[i+1][n-1] - dungeon[i][n-1]);
        }
        for (int j = n-2; j >= 0; j--) {
            dungeon[m-1][j] = Math.max(0, dungeon[m-1][j+1] - dungeon[m-1][j]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int nextHP = Math.min(dungeon[i+1][j], dungeon[i][j+1]);
                dungeon[i][j] = Math.max(0, nextHP - dungeon[i][j]);
            }
        }

        return dungeon[0][0] + 1;
    }
}