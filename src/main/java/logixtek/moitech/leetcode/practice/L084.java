package logixtek.moitech.leetcode.practice;

public class L084 {
    public static void main(String[] args) {
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

        int maxRectangle = 0;
        for (int i = 0; i < len; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            maxRectangle = Math.max(maxRectangle, width * heights[i]);
        }

        return maxRectangle;
    }
}
