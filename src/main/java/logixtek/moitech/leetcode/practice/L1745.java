package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class L1745 {

    public static void main(String[] args) {
        // TODO - TLE
        System.out.println(checkPartitioning("abcbdd")); // true
        System.out.println(checkPartitioning("bcbddxy")); // false
        System.out.println(checkPartitioning("bbab")); // true
    }

    public static boolean checkPartitioning(String s) {
        int n = s.length();

        List<Integer> firstSub = new ArrayList<>();
        List<Integer> thirdSub = new ArrayList<>();

        for (int i = 1; i < n - 1; i++) {
            if (isPalindrome(s, 0, i)) firstSub.add(i);
        }
        for (int i = 2; i < n; i++) {
            if (isPalindrome(s, i, n)) thirdSub.add(i);
        }

        for (int first : firstSub) {
            for (int third : thirdSub) {
                if (first + 1 == third || first + 1 < third && isPalindrome(s, first, third)) return true;
            }
        }

        return false;
    }

    private static boolean isPalindrome(String s, int begin, int end) {
        for (int i = 0; i < ((end - begin) / 2); i++) {
            if (s.charAt(begin + i) != s.charAt(end - i - 1)) return false;
        }
        return true;
    }
}
