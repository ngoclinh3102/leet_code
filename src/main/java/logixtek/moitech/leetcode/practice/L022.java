package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class L022 {
    public static List<String> generateParenthesis(int n) {
        var list = new ArrayList<String>();
        generateParenthesis(list, "", n, n);
        return list;
    }

    private static void generateParenthesis(List<String> list, String s, int open, int close) {
        if (open > 0) {
            generateParenthesis(list, s + "(", open - 1, close);
        }
        if (close > open) {
            generateParenthesis(list, s + ")", open, close - 1);
        }
        if (open == 0 && close == 0) {
            list.add(s);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(15));
    }
}
