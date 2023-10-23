package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.List;

public class L127 {
    public static void main(String[] args) {
        int i = ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }

    private static boolean isAdjacent(String s1, String s2) {
        int diff = 0;
        int i = 0;
        while (i < s1.length() && diff < 2) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            i++;
        }

        return diff < 2;
    }
}
