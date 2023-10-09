package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;

public class L859 {
    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        var diff = new ArrayList<Integer>();
        var same = new ArrayList<Character>();
        var swappable = false;

        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (diff.size() == 2) {
                    return false;
                }
                else {
                    diff.add(i);
                }
            }
            if (same.contains(s.charAt(i))) {
                swappable = true;
            }
            same.add(s.charAt(i));
        }

        return (s.equals(goal) && swappable)
                || (diff.size() == 2 && s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) && s.charAt(diff.get(1)) == goal.charAt(diff.get(0)));
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("aba", "aca"));
    }
}
