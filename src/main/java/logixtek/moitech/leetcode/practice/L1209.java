package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.CharacterCount;

import java.util.Stack;

public class L1209 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2)); // "abcd"
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3)); // "aa"
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2)); // "ps"
    }

    public static String removeDuplicates(String s, int k) {
        Stack<CharacterCount> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().character != c) {
                stack.push(CharacterCount.of(c));
            }
            else if (stack.peek().count + 1 == k) {
                stack.pop();
            }
            else {
                stack.peek().count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (CharacterCount cc : stack) sb.append(cc.toString());

        return sb.toString();
    }
}
