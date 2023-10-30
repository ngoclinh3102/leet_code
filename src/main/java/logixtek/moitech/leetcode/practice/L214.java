package logixtek.moitech.leetcode.practice;

public class L214 {

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abcde"));
    }

    public static String shortestPalindrome(String s) {
        char[] sarray = s.toCharArray();

        int farthestEnd = sarray.length - 1;
        while (farthestEnd > 0) {
            int left = 0;
            int right = farthestEnd;

            while (left < right && sarray[left] == sarray[right]) {
                left++;
                right--;
            }

            if (left >= right) break;

            farthestEnd--;
        }

        return new StringBuilder(s.substring(++farthestEnd)).reverse().append(s).toString();
    }
}
