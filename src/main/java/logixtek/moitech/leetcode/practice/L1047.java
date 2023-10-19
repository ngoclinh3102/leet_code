package logixtek.moitech.leetcode.practice;

import java.util.Stack;

public class L1047 {

    public static void main(String[] args) {
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (stack.size() > 0 && ch == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }

        return stack.toString();
    }
}
