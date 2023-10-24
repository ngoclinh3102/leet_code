package logixtek.moitech.leetcode.practice;

import java.util.HashMap;

public class L149 {

    // TODO - most points in line
    public static void main(String[] args) {
//        int[][] points = {{1,1},{2,2},{3,3}};  // 3
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};  // 4
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        int n = points.length;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 1; i < n; i++) {
            int[] a = points[i];
            for (int j = 0; j < i; j++) {
                int[] b = points[j];

                double slope = (a[0] != b[0]) ? ((double) a[1] - b[1]) / ((double) a[0] - b[0]) : 0f;
                double intercept = a[1] - slope * a[0];

                String line = slope != 0f
                              ? String.format("%f=%f", 1f, intercept/slope)
                              : String.format("%f=%f", 0f, intercept);
                map.merge(line, 1, Integer::sum);
            }
        }

        int max = 1;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }

        return max;
    }
}
