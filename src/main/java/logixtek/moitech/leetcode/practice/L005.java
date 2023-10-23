package logixtek.moitech.leetcode.practice;

public class L005 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbf"));
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int left = i;
            int right = i;
            char c = chars[i];

            while (right < chars.length - 1 && chars[right + 1] == c) right++;

            while (left > 0 && right < chars.length - 1 && chars[left - 1] == chars[right + 1]) {
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
