package logixtek.moitech.leetcode.practice;

public class L712 {

    public static int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i=1; i<=n1; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }

        for (int i=1; i<=n2; i++) {
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }

        for (int i1=1; i1<=n1; i1++) {
            for (int i2=1; i2<=n2; i2++) {
                dp[i1][i2] = s1.charAt(i1-1) == s2.charAt(i2-1)
                             ? dp[i1-1][i2-1]
                             : Math.min((dp[i1-1][i2] + s1.charAt(i1-1)), (dp[i1][i2-1] + s2.charAt(i2-1)));
            }
        }

        return dp[n1][n2];
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete", "leet"));
    }
}
