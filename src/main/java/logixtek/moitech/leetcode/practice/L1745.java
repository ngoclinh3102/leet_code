package logixtek.moitech.leetcode.practice;

public class L1745 {

    public static void main(String[] args) {
        System.out.println(checkPartitioning("juchzcedhfesefhdeczhcujzzvbmoeombv")); // true
    }

    public static boolean checkPartitioning(String s) {
        char[] sarray = s.toCharArray();
        boolean[][] isPalindrome = new boolean[sarray.length][sarray.length];

        for (int i = 0; i < sarray.length; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i + 1 < sarray.length; i++) {
            isPalindrome[i][i+1] = sarray[i] == sarray[i+1];
        }
        for (int len = 2; len < sarray.length; len++) {
            for (int i = 0; i + len < sarray.length; i++) {
                isPalindrome[i][i+len] = isPalindrome[i+1][i+len-1] && sarray[i] == sarray[i+len];
            }
        }

        for (int i = 0; i + 2 < sarray.length; i++) {
            if (isPalindrome[0][i]) {
                for (int j = i + 1; j + 1 < sarray.length; j++) {
                    if (isPalindrome[i+1][j] && isPalindrome[j+1][sarray.length-1]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
