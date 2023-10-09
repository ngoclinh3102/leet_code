package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.Stack;

public class L503 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(1, 2, 1))); // [2,-1,2]
        System.out.println(Arrays.toString(nextGreaterElements(1,8,-1,-100,-1,222,1111111,-111111))); // [8,222,222,-1,222,1111111,-1,1]
    }

    public static int[] nextGreaterElements(int... nums) {
        int[] nextCircularlyGreater = new int[nums.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) stack.pop();

            if (!stack.isEmpty()) {
                nextCircularlyGreater[i] = stack.peek();
            }
            else {
                nextCircularlyGreater[i] = -1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        nextCircularlyGreater[i] = nums[j];
                        break;
                    }
                }
            }
            stack.push(nums[i]);
        }

        return nextCircularlyGreater;
    }

    public static int[] nextGreaterElements2(int... nums) {
        int[] nextCircularlyGreater = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            nextCircularlyGreater[i] = Integer.MIN_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    nextCircularlyGreater[i] = nums[j];
                    break;
                }
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nextCircularlyGreater[i] == Integer.MIN_VALUE) {
                nextCircularlyGreater[i] = -1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        nextCircularlyGreater[i] = nums[j];
                        break;
                    }
                }
            }
        }

        return nextCircularlyGreater;
    }

    public static int[] nextGreaterElements3(int... nums) {
        int[] nextCircularlyGreater = new int[2* nums.length];

        for (int i = 0; i < nums.length; i++) {
            nextCircularlyGreater[i] = nextCircularlyGreater [i+ nums.length] = nums[i];
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 2*nums.length - 1; i >= 0 ; i--) {
            int num = nextCircularlyGreater[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            nextCircularlyGreater[i] = (!stack.isEmpty()) ? stack.peek() : -1;
            stack.push(num);
        }

        return Arrays.copyOfRange(nextCircularlyGreater, 0, nums.length);
    }
}
