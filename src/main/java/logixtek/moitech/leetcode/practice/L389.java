package logixtek.moitech.leetcode.practice;

public class L389 {

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde")); // e
    }

    public static char findTheDifference(String s, String t) {
        int charSum = 0;
        for (char c : s.toCharArray()) charSum -= c;
        for (char c : t.toCharArray()) charSum += c;
        return (char) charSum;
    }
}
