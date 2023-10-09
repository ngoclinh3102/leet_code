package logixtek.moitech.leetcode.practice;

public class L010 {

    public static void main(String[] args) {
    }

    public static boolean isMatch(String s, String p) {
        char[] sarray = s.toCharArray();
        char[] parray = p.toCharArray();
        boolean[][] dp = new boolean[sarray.length + 1][parray.length + 1];

        dp[0][0] = true;
        for (int j = 1; j <= parray.length; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }

        for (int i = 1; i <= sarray.length; i++) {
            for (int j = 1; j <= parray.length; j++) {
                if (parray[j-1] == sarray[i-1] || parray[j-1] == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (parray[j-1] == '*') {
                    dp[i][j] = dp[i][j-2];
                    if (parray[j-2] == sarray[i-1] || parray[j-2] == '.') {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }
        }

        return dp[sarray.length][parray.length];
    }
}
