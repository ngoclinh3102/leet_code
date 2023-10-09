package logixtek.moitech.leetcode.practice;

public class L994 {

    public static void main(String[] args) {
        L994 l994 = new L994();
        var grid1 = new int[][] {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1},
        };
        var grid2 = new int[][] {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 2},
        };
        var grid3= new int[][] {
                {0,2},
        };
        var grid4 = new int[][] {
                {2, 1, 1},
                {1, 1, 1},
                {0, 1, 2},
        };
        var grid5 = new int[][] {
                {2, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        System.out.println(l994.orangesRotting(grid1)); // 4
        System.out.println(l994.orangesRotting(grid2)); // -1
        System.out.println(l994.orangesRotting(grid3)); // 0
        System.out.println(l994.orangesRotting(grid4)); // 2
        System.out.println(l994.orangesRotting(grid5)); // 58
    }

    public int orangesRotting(int[][] grid) {
//        for (int[] row : grid) System.out.println(Arrays.toString(row)); System.out.println();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    infect(grid, i, j);
                }
            }
        }

        int minInfectingTime = 2;
        for (int[] row : grid) {
            for (int rottenOrange : row) {
                if (rottenOrange == 1) return -1;
                if (rottenOrange > minInfectingTime) minInfectingTime = rottenOrange;
            }
        }

//        for (int[] row : grid) System.out.println(Arrays.toString(row)); System.out.println();

        return minInfectingTime - 2;
    }

    private void infect(int[][] grid, int i, int j) {
        int CONFIRMED_PATIENT = grid[i][j];

        if ((i > 0) && (grid[i-1][j] == 1 || grid[i-1][j] > CONFIRMED_PATIENT + 1)) {
            grid[i-1][j] = CONFIRMED_PATIENT + 1;
            infect(grid, i-1, j);
        }

        if ((j > 0) && (grid[i][j-1] == 1 || grid[i][j-1] > CONFIRMED_PATIENT + 1)) {
            grid[i][j-1] = CONFIRMED_PATIENT + 1;
            infect(grid, i, j-1);
        }

        if ((i + 1 < grid.length) && (grid[i+1][j] == 1 || grid[i+1][j] > CONFIRMED_PATIENT + 1)) {
            grid[i+1][j] = CONFIRMED_PATIENT + 1;
            infect(grid, i+1, j);
        }

        if ((j + 1 < grid[0].length) && (grid[i][j+1] == 1 || grid[i][j+1] > CONFIRMED_PATIENT + 1)) {
            grid[i][j+1] = CONFIRMED_PATIENT + 1;
            infect(grid, i, j+1);
        }
    }
}
