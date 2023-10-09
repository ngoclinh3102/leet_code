package logixtek.moitech.leetcode.practice;

public class L647 {

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc")); // 3
        System.out.println(countSubstrings("aaa")); // 6
        System.out.println(countSubstrings("abbbac")); // 10
    }

    public static int countSubstrings(String s) {
        int count = 0;
        int left, right;
        for (int i = 0; i < s.length(); i++) {
            count++;

            left = right = i;

            while (++right < s.length() && s.charAt(right) == s.charAt(i)) count++;
            right--;

            while (left > 0 && right + 1 < s.length() && s.charAt(--left) == s.charAt(++right)) count++;
        }
        return count;
    }
}
