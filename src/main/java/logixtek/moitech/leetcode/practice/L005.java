package logixtek.moitech.leetcode.practice;

public class L005 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbf"));
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();

        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i-1]) continue;

            int left = i;
            int right = i;

            while (right + 1 < chars.length && chars[right + 1] == chars[i]) right++;

            while (left > 0 && right + 1 < chars.length && chars[left - 1] == chars[right + 1]) {
                left--;
                right++;
            }

            if (right - left > end - start) {
                start = left;
                end = right;
            }
        }

        return s.substring(start, ++end);
    }
}
