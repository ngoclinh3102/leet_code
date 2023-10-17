package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L115 {

    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }
    public static int numDistinct(String s, String t) {
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();

        int[][] dp = new int[tarray.length+1][sarray.length+1];

        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= tarray.length; i++) {
            for (int j = 1; j <= sarray.length; j++) {
                if (sarray[j-1] == tarray[i-1]) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[tarray.length][sarray.length];
    }
}
