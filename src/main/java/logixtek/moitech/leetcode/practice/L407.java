package logixtek.moitech.leetcode.practice;

public class L407 {

    public static void main(String[] args) {
        var heightMap1 = new int[][]{
                {12, 13, 1, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}
        };
        var heightMap2 = new int[][]{
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1},
        };
        var heightMap3 = new int[][]{
                {2, 2, 2},
                {2, 1, 2},
                {2, 1, 2},
                {2, 1, 2},
        };
        var heightMap4 = new int[][]{
                {18, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        var heightMap5 = new int[][]{
                {14, 17, 18, 16, 14, 16},
                {17, 3, 10, 2, 3, 8},
                {11, 10, 4, 7, 1, 7},
                {13, 7, 2, 9, 8, 10},
                {13, 1, 3, 4, 8, 6},
                {20, 3, 3, 9, 10, 8},
        };
        var heightMap6 = new int[][]{
                {14,17,12,13,20,14},
                {12,10,5,8,9,5},
                {16,1,4,7,2,1},
                {17,4,3,1,7,2},
                {16,6,5,8,7,6},
                {17,10,4,8,5,6},
        };
        L407 l407 = new L407();
        System.out.println(l407.trapRainWater(heightMap6)); // 12
        System.out.println(l407.trapRainWater(heightMap5)); // 25
        System.out.println(l407.trapRainWater(heightMap4)); // 0
        System.out.println(l407.trapRainWater(heightMap3)); // 0
        System.out.println(l407.trapRainWater(heightMap2)); // 4
        System.out.println(l407.trapRainWater(heightMap1)); // 14
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        int capacity = 0;
        var rainMap = new int[m][n];

        for (int j = 0; j < n; j++) {
            rainMap[0][j] = heightMap[0][j];
            rainMap[m-1][j] = heightMap[m-1][j];
        }
        for (int i = 1; i + 1 < m; i++) {
            rainMap[i][0] = heightMap[i][0];
            rainMap[i][n-1] = heightMap[i][n-1];
            for (int j = 1; j + 1 < n; j++) {
                rainMap[i][j] = 20_000;
                capacity += 20_000 - heightMap[i][j];
            }
        }

        boolean isDrained = false;
        while (!isDrained) {
            isDrained = true;

            for (int i = 1; i + 1 < m; i++) {
                for (int j = 1; j + 1 < n; j++) {
                    capacity -= rainMap[i][j];
                    rainMap[i][j] = Math.max(heightMap[i][j], minAround(rainMap, i, j));
                    capacity += rainMap[i][j];
                }
            }

            for (int i = m - 2; i > 0 ; i--) {
                for (int j = n - 2; j > 0; j--) {
                    capacity -= rainMap[i][j];
                    rainMap[i][j] = Math.max(heightMap[i][j], minAround(rainMap, i, j));
                    capacity += rainMap[i][j];

                    isDrained = isDrained
                                && (rainMap[i][j] >= rainMap[i+1][j] || rainMap[i+1][j] <= heightMap[i+1][j])
                                && (rainMap[i][j] >= rainMap[i][j+1] || rainMap[i][j+1] <= heightMap[i][j+1]);
                }
            }
        }

        return capacity;
    }

    private int minAround(int[][] rainMap, int x, int y) {
        return Math.min(
                Math.min(rainMap[x - 1][y], rainMap[x + 1][y]),
                Math.min(rainMap[x][y - 1], rainMap[x][y + 1])
        );
    }
}