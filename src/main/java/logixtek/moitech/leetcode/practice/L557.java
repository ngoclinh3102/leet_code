package logixtek.moitech.leetcode.practice;

public class L557 {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        char[] sarray = s.toCharArray();

        for (int i = 0; i < sarray.length; i++) {
            int p = i;
            while (i < sarray.length && sarray[i] != ' ') i++;
            int q = i - 1;
            while (p < q) {
                char temp = sarray[p];
                sarray[p++] = sarray[q];
                sarray[q--] = temp;
            }
        }

        return String.valueOf(sarray);
    }
}
