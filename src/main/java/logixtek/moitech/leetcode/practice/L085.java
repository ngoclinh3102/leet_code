package logixtek.moitech.leetcode.practice;

public class L085 {

    public static void main(String[] args) {

    }

    public static int maximalRectangle(char[][] matrix) {
        int maxRectangle = 0;
        int[] histogram = new int[matrix[0].length];

        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '1') {
                    histogram[i]++;
                }
                else {
                    histogram[i] = 0;
                }
            }
            maxRectangle = Math.max(maxRectangle, largestRectangleArea(histogram));
        }

        return maxRectangle;
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

        int maxRect = 0;
        for (int i = 0; i < len; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            maxRect = Math.max(maxRect, width * heights[i]);
        }

        return maxRect;
    }
}
