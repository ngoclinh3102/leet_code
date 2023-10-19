package logixtek.moitech.leetcode.practice;


public class L844 {

    public static void main(String[] args) {
    }

    public static boolean backspaceCompare(String s, String t) {
        int sSharp = 0;
        int tSharp = 0;

        int i = s.length() - 1;
        int j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (sSharp > 0 || s.charAt(i) == '#')) {
                if (s.charAt(i) == '#') {
                    sSharp++;
                }
                else {
                    sSharp--;
                }
                i--;
            }

            while (j >= 0 && (tSharp > 0 || t.charAt(j) == '#')) {
                if (t.charAt(j) == '#') {
                    tSharp++;
                }
                else {
                    tSharp--;
                }
                j--;
            }

            if ((i >= 0 || j >= 0) && (i < 0 || j < 0 || s.charAt(i) != t.charAt(j))) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}
