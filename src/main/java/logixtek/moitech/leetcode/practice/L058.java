package logixtek.moitech.leetcode.practice;

public class L058 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(lengthOfLastWord("Hello World")); // 5
    }

    public static int lengthOfLastWord(String s) {
        String[] arr = s.trim().split(" ");
        return arr[arr.length - 1].length();
    }
}
