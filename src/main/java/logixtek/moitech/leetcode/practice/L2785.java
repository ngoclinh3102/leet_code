package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L2785 {
    public static void main(String[] args) {
        System.out.println(sortVowels_Counting("lEetcOde"));
    }

    public static String sortVowels_Counting(String s) {
        char[] sarray = s.toCharArray();
        int[] vowels = new int[128];

        for (int i = 0; i < sarray.length; i++) {
            if (isVowels(sarray[i])) {
                vowels[sarray[i]]++;
                sarray[i] = '#';
            }
        }

        int map = 'A';
        for (int i = 0; i < sarray.length; i++) {
            if (sarray[i] == '#') {
                while (map < 128 && vowels[map] == 0) map++;

                sarray[i] = (char) map;
                vowels[map]--;
            }
        }

        return String.valueOf(sarray);
    }

    public static String sortVowels_Sorting(String s) {
        char[] sarray = s.toCharArray();
        char[] vowels = new char[sarray.length];

        int len = 0;
        for (int i = 0; i < sarray.length; i++) {
            if (isVowels(sarray[i])) {
                vowels[len++] = sarray[i];
                sarray[i] = '#';
            }
        }

        Arrays.sort(vowels, 0, len);

        len = 0;
        for (int i = 0; i < sarray.length; i++) {
            if (sarray[i] == '#') {
                sarray[i] = vowels[len++];
            }
        }

        return String.valueOf(sarray);
    }

    private static boolean isVowels(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
