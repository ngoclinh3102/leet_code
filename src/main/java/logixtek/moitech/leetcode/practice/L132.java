package logixtek.moitech.leetcode.practice;

public class L132 {

    public static void main(String[] args) {
        System.out.println(minCut("abcbdd"));
    }

    public static int minCut(String s) {
        char[] sarray = s.toCharArray();
        boolean[][] isPalindrome = new boolean[sarray.length][sarray.length];

        for (int i = 0; i < sarray.length; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i + 1 < sarray.length; i++) {
            if (sarray[i] == sarray[i+1]) {
                isPalindrome[i][i+1] = true;
            }
        }
        for (int len = 2; len < sarray.length; len++) {
            for (int i = 0; i + len < sarray.length; i++) {
                if (isPalindrome[i+1][i+len-1] && sarray[i] == sarray[i+len]) {
                    isPalindrome[i][i+len] = true;
                }
            }
        }

        int[] dp = new int[sarray.length];
        for (int i = 0; i < sarray.length; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < sarray.length; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            }
            else {
                for (int j = 1; j <= i; j++) {
                    if (isPalindrome[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }

        return dp[sarray.length - 1];
    }
}
