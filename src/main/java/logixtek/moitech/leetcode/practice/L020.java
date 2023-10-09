package logixtek.moitech.leetcode.practice;

import java.util.Stack;

public class L020 {

    public static void main(String[] args) {
        System.out.println(isValid("((()))({}){}[][]({}({}))"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(', '[', '{' -> stack.push(c);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<Integer> roundStack = new Stack<>();
        Stack<Integer> squareStack = new Stack<>();
        Stack<Integer> angleStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> roundStack.push(i);
                case '[' -> squareStack.push(i);
                case '{' -> angleStack.push(i);
                case ')' -> {
                    if (roundStack.isEmpty()) return false;
                    if (!squareStack.isEmpty() && roundStack.peek() < squareStack.peek()) return false;
                    if (!angleStack.isEmpty() && roundStack.peek() < angleStack.peek()) return false;
                    roundStack.pop();
                }
                case ']' -> {
                    if (squareStack.isEmpty()) return false;
                    if (!roundStack.isEmpty() && squareStack.peek() < roundStack.peek()) return false;
                    if (!angleStack.isEmpty() && squareStack.peek() < angleStack.peek()) return false;
                    squareStack.pop();
                }
                case '}' -> {
                    if (angleStack.isEmpty()) return false;
                    if (!roundStack.isEmpty() && angleStack.peek() < roundStack.peek()) return false;
                    if (!squareStack.isEmpty() && angleStack.peek() < squareStack.peek()) return false;
                    angleStack.pop();
                }
            }
        }
        return roundStack.isEmpty() && squareStack.isEmpty() && angleStack.isEmpty();
    }
}
