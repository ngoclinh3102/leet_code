package logixtek.moitech.leetcode.practice;

public class L2430 {

    public static void main(String[] args) {
        // TODO - delete aabaab - TLE
        System.out.println(deleteString("abcabcdabc")); //
    }

    public static int deleteString(String s) {
        int n = s.length();
        int[] dp = new int[n];
        char[] sarray = s.toCharArray();

        int prevMax = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j - i <= n - j; j++) {
                if (isDeletable(sarray, i, j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (prevMax < dp[i]) {
                        prevMax = dp[i];
                        break;
                    }
                }
            }
        }

        return dp[0] + 1;
    }

    private static boolean isDeletable(char[] sarray, int i, int j) {
        for (int k = 0; k + i < j; k++) {
            if (sarray[i+k] != sarray[j+k]) {
                return false;
            }
        }
        return true;
    }
}
