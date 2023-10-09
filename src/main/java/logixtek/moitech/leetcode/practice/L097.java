package logixtek.moitech.leetcode.practice;

public class L097 {

    public static void main(String[] args) {
        System.out.println(isInterleave("aa", "aaaa", "aaaaaa")); // false
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbca12c")); // false
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false
        System.out.println(isInterleave("db", "b", "cbb")); // false
        System.out.println(isInterleave("a", "", "b")); // false
        System.out.println(isInterleave("aabaac", "aadaaeaaf", "aadaaeaabaafaac")); // true
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
        System.out.println(isInterleave("aa", "ab", "aaba")); // true
        System.out.println(isInterleave("a", "", "a")); // true
        System.out.println(isInterleave("", "", "")); // true
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[] paths = new boolean[s2.length() + 1];

        paths[0] = true;

        for (int j = 1; j <= s2.length(); j++) paths[j] = paths[j-1] && s2.charAt(j-1) == s3.charAt(j-1);

        for (int i = 1; i <= s1.length() ; i++) {
            paths[0] = paths[0] && s1.charAt(i-1) == s3.charAt(i-1);
            for (int j = 1; j <= s2.length(); j++) {
                paths[j] = (paths[j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (paths[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }

        return paths[s2.length()];
    }

    public static boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] paths = new boolean[s1.length() + 1][s2.length() + 1];

        paths[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) paths[i][0] = paths[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        for (int j = 1; j <= s2.length(); j++) paths[0][j] = paths[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);

        for (int i = 1; i <= s1.length() ; i++) {
            for (int j = 1; j <= s2.length(); j++) {
                paths[i][j] = (paths[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (paths[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }

        return paths[s1.length()][s2.length()];
    }
}
