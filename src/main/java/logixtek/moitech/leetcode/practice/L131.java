package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L131 {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        char[] sarray = s.toCharArray();
        List<List<String>> list = new LinkedList<>();

        compute(sarray, list, new ArrayList<>(), 0);

        return list;
    }

    private static void compute(char[] sarray, List<List<String>> list, List<String> partition, int i) {
        if (i == sarray.length) {
            list.add(new ArrayList<>(partition));
            return;
        }
        for (int j = i + 1; j <= sarray.length; j++) {
            if (isPalindrome(sarray, i, j - 1)) {
                partition.add(String.valueOf(sarray, i, j - i));
                compute(sarray, list, partition, j);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(char[] sarray, int i, int j) {
        while (i < j) {
            if (sarray[i] != sarray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
