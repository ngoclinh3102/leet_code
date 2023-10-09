package logixtek.moitech.leetcode.practice;

public class L1037 {

    public static void main(String[] args) {
//        System.out.println(triangleArea(new int[]{1,1}, new int[] {2,2}, new int[] {3,3}));
        System.out.println(isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}})); // true
        System.out.println(isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}})); // false
        System.out.println(isBoomerang(new int[][]{{0, 0}, {1, 2}, {1, 2}})); // false
        System.out.println(isBoomerang(new int[][]{{0, 0}, {0, 2}, {2, 1}})); // true
    }

    public static boolean isBoomerang(int[][] points) {
        var A = points[0];
        var B = points[1];
        var C = points[2];
        return A[0] * (B[1] - C[1]) + B[0] * (C[1] - A[1]) + C[0] * (A[1] - B[1]) != 0;
    }

    private static double triangleArea(int [] a, int[] b, int[] c) {
        return 0.5 * Math.abs((a[0] * (b[1] - c[1])) + (b[0] * (c[1] - a[1])) + (c[0] * (a[1] - b[1])));
    }
}
