package logixtek.moitech.leetcode.practice;

public class L014 {

    public static void main(String[] args) {
        System.out.println("aaa".startsWith(""));
        System.out.println(longestCommonPrefix("dog","racecar","car"));
    }

    public String longestCommonPrefix2(String[] strs) {
        for (int i = 1; i < strs.length && strs[0].length() > 0; i++) {
            while (!strs[i].startsWith(strs[0])) {
                strs[0] = strs[0].substring(0, strs[0].length() - 1);
            }
        }
        return strs[0];
    }

    public static String longestCommonPrefix(String... strs) {
        for (int i = 1; i < strs.length && strs[0].length() > 0; i++) {
            int len = lengthOfCommonPrefix(strs[0], strs[i]);
            strs[0] = strs[0].substring(0, len);
        }
        return strs[0];
    }

    private static int lengthOfCommonPrefix(String s1, String s2) {
        int len = 0;
        while (len < s1.length() && len < s2.length() && s1.charAt(len) == s2.charAt(len)) {
            len++;
        }
        return len;
    }
}
