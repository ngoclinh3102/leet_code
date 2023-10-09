package logixtek.moitech.leetcode.practice;

public class L1615 {

    public static void main(String[] args) {
        System.out.println(maximalNetworkRank(4, new int[][]{{0,1},{0,3},{1,2},{1,3}})); // 4
        System.out.println(maximalNetworkRank(5, new int[][]{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}})); // 5
        System.out.println(maximalNetworkRank(8, new int[][]{{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}})); // 5
        System.out.println(maximalNetworkRank(15, new int[][]{{8,12},{5,11},{5,12},{9,4},{0,9},{1,8},{10,2},{13,14},{3,4},{11,3},{11,8},{5,10}})); // 6
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        int[] citiesRank = new int[n];
        boolean[][] connected = new boolean[n][n];

        for (int[] road : roads) {
            citiesRank[road[0]]++;
            citiesRank[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }

        int ans = 0;
        for (int i = 0; i + 1 < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, citiesRank[i] + citiesRank[j] - (connected[i][j] ? 1 : 0));
            }
        }

        return ans;
    }
}
