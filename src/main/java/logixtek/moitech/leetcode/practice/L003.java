package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L003 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("abba")); // 2
        System.out.println(lengthOfLongestSubstring("abc")); // 3
        System.out.println(lengthOfLongestSubstring("dvdf")); // 3
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("abcdef")); // 6
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] exist = new int[128];
        Arrays.fill(exist, -1);

        int maxLength = 0;
        int checkpoint = 0;
        for (int i = 0; i < s.length() && maxLength < exist.length; i++) {
            if (exist[s.charAt(i)] >= checkpoint) {
                checkpoint = exist[s.charAt(i)] + 1;
            }
            maxLength = Math.max(maxLength, i - checkpoint + 1);
            exist[s.charAt(i)] = i;
        }
        return maxLength;
    }
}
