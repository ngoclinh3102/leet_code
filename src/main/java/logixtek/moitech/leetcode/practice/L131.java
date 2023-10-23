package logixtek.moitech.leetcode.practice;

import java.util.LinkedList;
import java.util.List;

public class L131 {

    public static void main(String[] args) {
        // TODO - palindrome
    }

    public static List<List<String>> partition(String s) {
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
        List<List<String>> list = new LinkedList<>();
        for (int i = 0; i + 1 < sarray.length; i++) {
            if (isPalindrome[0][i] && isPalindrome[i+1][sarray.length - 1]) {
            }
        }

        return list;
    }
}
