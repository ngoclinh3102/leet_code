package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.List;

public class L139 {

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet","code")));
        System.out.println(wordBreak("abcd", Arrays.asList("a","abc","b","cd")));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        int max_length = 0;
        for (String word : wordDict) {
            if (word.length() > max_length) {
                max_length = word.length();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i-max_length - 1, 0); j--) {
                if (dp[i] && wordDict.contains(s.substring(j,1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
