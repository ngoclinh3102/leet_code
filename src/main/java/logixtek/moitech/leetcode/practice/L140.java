package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class L140 {

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> answer = new ArrayList<>();
        link(answer, wordDict, s, "", 0);

        return answer;
    }

    private static void link(List<String> answer, List<String> wordDict, String s, String current, int i) {
        if (i == s.length()) {
            answer.add(current.trim());
            return;
        }

        for (int j = i + 1; j <= i + 10 && j <= s.length(); j++) {
            if (wordDict.contains(s.substring(i, j))) {
                link(answer, wordDict, s, current + s.substring(i, j) + " ", j);
            }
        }
    }
}
