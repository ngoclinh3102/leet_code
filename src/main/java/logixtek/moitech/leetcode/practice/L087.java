package logixtek.moitech.leetcode.practice;

public class L087 {

    public static void main(String[] args) {
        // TODO: TLE => 3D DP Array
//        System.out.println(isScramble("a", "a")); // true
//        System.out.println(isScramble("abb", "bba")); // true
//        System.out.println(isScramble("great", "rgeat")); // true
//        System.out.println(isScramble("abcde", "caebd")); // false
        System.out.println(isScramble("abcdef", "fdecba")); // true
//        System.out.println(isScramble("dcoiorfhkqdwp", "rdpihwfkcooqd")); // false
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        for (int i = 1; i < s1.length(); i++) {
            var s1_1 = s1.substring(0, i);
            var s1_2 = s1.substring(i);
            if (isScramble(s1_1, s2.substring(0, i)) && isScramble(s1_2, s2.substring(i))) {
                return true;
            }
            if (isScramble(s1_2, s2.substring(0, s1.length() - i)) && isScramble(s1_1, s2.substring(s1.length() - i))) {
                return true;
            }
        }
        return false;
    }
}
