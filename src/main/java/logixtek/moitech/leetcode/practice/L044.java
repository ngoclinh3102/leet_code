package logixtek.moitech.leetcode.practice;

public class L044 {

    public static void main(String[] args) {
        System.out.println(isMatch("acdcb","a*c?b"));
    }

    public static boolean isMatch(String s, String p) {
        char[] parray = p.toCharArray();
        char[] sarray = s.toCharArray();

        boolean[][] dp = new boolean[parray.length+1][sarray.length+1];

        dp[0][0] = true;
        for (int i = 1; i <= parray.length; i++) {
            if (parray[i-1] == '*') dp[i][0] = true;
            else break;
        }

        for (int i = 1; i <= parray.length; i++) {
            for (int j = 1; j <= sarray.length; j++) {
                dp[i][j] = switch (parray[i-1]) {
                    case '*' -> dp[i-1][j] || dp[i][j-1];
                    case '?' -> dp[i-1][j-1];
                    default  -> dp[i-1][j-1] && parray[i-1] == sarray[j-1];
                };
            }
        }

        for (var row : dp) {
            for (var cell : row) {
                System.out.printf("%6s", cell ? 1 : 0);
            }
            System.out.println();
        }

        return dp[parray.length][sarray.length];
    }
}
