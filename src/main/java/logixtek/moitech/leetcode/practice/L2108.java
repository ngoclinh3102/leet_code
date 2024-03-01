package logixtek.moitech.leetcode.practice;

public class L2108 {

    public static void main(String[] args) {

    }

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            int i = 0;
            while (2 * i < word.length() - 1) {
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    break;
                }
                i++;
            }
            if (2 * i >= word.length() - 1) {
                return word;
            }
        }
        return "";
    }
}
