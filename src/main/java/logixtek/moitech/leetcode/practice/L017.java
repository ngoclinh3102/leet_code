package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class L017 {

    private static final String[][] NOKIA_PHONE = {
            {},
            {},
            {"a","b","c"},
            {"d","e","f"},
            {"g","h","i"},
            {"j","k","l"},
            {"m","n","o"},
            {"p","q","r","s"},
            {"t","u","v"},
            {"w","x","y","z"},
    };

    private static void combine(List<String> list, StringBuilder item, String digits, int index) {
        if (index == digits.length()) {
            list.add(item.toString());
            return;
        }
        int number = digits.charAt(index) - 48;
        for (int i = 0; i < NOKIA_PHONE[number].length; i++) {
            item.append(NOKIA_PHONE[number][i]);
            combine(list, item, digits, index + 1);
            item.deleteCharAt(item.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        var list = new ArrayList<String>();
        if (digits.length() > 0) {
            combine(list, new StringBuilder(), digits, 0);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
