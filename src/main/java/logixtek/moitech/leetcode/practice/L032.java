package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.Stack;

public class L032 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("")); // 0
        System.out.println(longestValidParentheses("(()")); // 2
        System.out.println(longestValidParentheses("()(()")); // 2
        System.out.println(longestValidParentheses("()()")); // 4
        System.out.println(longestValidParentheses(")()())")); // 4
        System.out.println(longestValidParentheses2("()(())")); // 6
        System.out.println(longestValidParentheses3("((()))")); // 6
    }

    public static int longestValidParentheses3(String s) {
        int longest = 0;
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') leftCount++;
            else rightCount++;

            if (leftCount == rightCount) {
                longest = Math.max(longest, leftCount + rightCount);
            }
            else if (leftCount < rightCount) {
                leftCount = rightCount = 0;
            }
        }

        leftCount = rightCount = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') rightCount++;
            else leftCount++;

            if (leftCount == rightCount) {
                longest = Math.max(longest, leftCount + rightCount);
            }
            else if (rightCount < leftCount) {
                leftCount = rightCount = 0;
            }
        }

        return longest;
    }

    public static int longestValidParentheses2(String s) {
        if (s.length() == 0 || s.length() == 1) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }

        return longest;
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        for (int i = 0; i < dp.length; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else if (!stack.isEmpty()) {
                dp[i] = stack.pop();
            }
        }

        int longest = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            int currentLength = 0;
            while (i >= 0 && dp[i] != -1) {
                currentLength += (i + 1 - dp[i]);
                i = dp[i] - 1;
            }
            longest = Math.max(longest, currentLength);
        }

        return longest;
    }
}
