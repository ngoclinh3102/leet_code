package logixtek.moitech.leetcode.practice;

import java.util.Stack;

public class L907 {

    public static void main(String[] args) {
//        System.out.println(sumSubarrayMins2(new int[]{3, 1, 2, 4}));            // 17
//        System.out.println(sumSubarrayMins2(new int[]{11, 81, 94, 43, 3}));     // 444
        System.out.println(sumSubarrayMins2(new int[]{1, 4, 7, 9, 12, 17}));    // 444
    }

    private static final int MOD = 1_000_000_007;

    public static int sumSubarrayMins2(int[] arr) {
        long sum = 0;

        var stack = new Stack<Integer>();
        stack.push(-1);

        for (int i = 0; i < arr.length; i++) {
            while (stack.peek() != -1 && arr[stack.peek()] > arr[i]) {
                sum += ((long) arr[stack.peek()] * (i - stack.peek()) * (stack.pop() - stack.peek()));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            sum += ((long) arr[stack.peek()] * (arr.length - stack.peek()) * (stack.pop() - stack.peek()));
        }

        return (int) (sum % MOD);
    }

    public static int sumSubarrayMins(int[] arr) {
        long sumOfMinimums = 0;

        for (int num : arr) {
            sumOfMinimums += num;
        }

        // STILL TOO LOW
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j + i < arr.length; j++) {
                arr[j] = Math.min(arr[j], arr[j + 1]);
                sumOfMinimums += arr[j];
            }
        }

        return (int) (sumOfMinimums % MOD);
    }
}
