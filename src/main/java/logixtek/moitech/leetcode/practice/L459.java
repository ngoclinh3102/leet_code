package logixtek.moitech.leetcode.practice;

public class L459 {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aa")); // true
        System.out.println(repeatedSubstringPattern("abab")); // true
        System.out.println(repeatedSubstringPattern("aba")); // false
        System.out.println(repeatedSubstringPattern("abcabcabcabc")); // true
    }

    public static boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }

    public static boolean repeatedSubstringPattern0(String s) {
        if (s.length() < 2) return false;

        int n = 2;
        while (n <= s.length()) {
            if (s.length() % n == 0) {
                String pattern = s.substring(0,s.length()/n);
                boolean isRepeated = true;
                for (int i = 1; i < n; i++) {
                    if (!pattern.equals(s.substring(pattern.length() * i, pattern.length() * (i + 1)))) {
                        isRepeated = false;
                        break;
                    }
                }
                if (isRepeated) return true;
            }
            n++;
        }

        return false;
    }
}
