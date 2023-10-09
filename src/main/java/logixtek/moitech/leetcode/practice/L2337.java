package logixtek.moitech.leetcode.practice;

public class L2337 {

    public static void main(String[] args) {
        System.out.println(canChange("_L__R__R_", "L______RR")); // true
        System.out.println(canChange("R_L_", "__LR")); // false
        System.out.println(canChange("_R", "R_")); // false
        System.out.println(canChange("_L", "LL")); // false
    }

    public static boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;
            if (i < n && j < n) {
                char cs = start.charAt(i);
                char ct = target.charAt(j);
                if (!((cs == 'L' && ct == 'L' && i >= j) || (cs == 'R' && ct == 'R' && i <= j))) {
                    return false;
                }
            }
            i++;
            j++;
        }
        return i == j;
    }

    public static boolean canChange2(String start, String target) {
        int n = start.length();
        char[] schar = start.toCharArray();
        char[] tchar = target.toCharArray();

        int[][] dp = new int[n][2];
        int ssize = 0;
        int tsize = 0;

        for (int i = 0; i < n; i++) {
            if (schar[i] != '_') {
                dp[ssize][0] = i + 1;
                ssize++;
            }
            if (tchar[i] != '_') {
                dp[tsize][1] = i + 1;
                tsize++;
            }
        }

        if (ssize != tsize) return false;

        for (int k = 0; k < ssize; k++) {
            int i = dp[k][0] - 1;
            int j = dp[k][1] - 1;
            if (schar[i] != tchar[j]) return false;
            if (schar[i] == 'L' && i < j) return false;
            if (schar[i] == 'R' && i > j) return false;
        }

        return true;
    }
}
