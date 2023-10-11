package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L1851 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 5}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(minInterval(intervals, queries)));
    }

    public static int[] minInterval(int[][] intervals, int[] queries) {
        // TODO - Sweep Line
        return queries;
    }
}
