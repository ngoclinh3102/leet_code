package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.Stack;

public class L084 {
    public static void main(String[] args) {
//        System.out.println(largestRectangleArea(2,4)); //4
//        System.out.println(largestRectangleArea(0,9)); // 9
//        System.out.println(largestRectangleArea(2,1,2)); // 3
//        System.out.println(largestRectangleArea(4,2,0,3,2,5)); // 6
//        System.out.println(largestRectangleArea(2,1,5,6,2,3)); //10
//        System.out.println(largestRectangleArea(7,9,3,4,5,8,2,1,3)); // 18
//        System.out.println(largestRectangleArea(7,9,3,4,5,0,8,2,1,3)); // ??
//        System.out.println(largestRectangleArea(4,5,6)); // 12
        System.out.println(largestRectangleArea(1,1)); // 2
    }

    public static int largestRectangleArea(int... heights) {
        int len = heights.length;

        int[] prevSmaller = new int[len];
        int[] nextSmaller = new int[len];

        prevSmaller[0] = -1;
        for (int i = 1; i < len; i++) {
            int prev = i - 1;
            while (prev >= 0 && heights[prev] >= heights[i]) {
                prev = prevSmaller[prev];
            }
            prevSmaller[i] = prev;
        }

        nextSmaller[len - 1] = len;
        for (int i = len - 1; i >= 0; i--) {
            int next = i + 1;
            while (next < len && heights[next] > heights[i]) {
                next = nextSmaller[next];
            }
            nextSmaller[i] = next;
        }

        int maxReactangle = 0;
        for (int i = 0; i < len; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            maxReactangle = Math.max(maxReactangle, width * heights[i]);
        }

        return maxReactangle;
    }
}
