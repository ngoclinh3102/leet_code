package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;

public class L435 {

    public static int eraseOverlapIntervals(int[][] intervals) {
        var removal = 0;
        if (intervals.length > 1) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            var currentPair = intervals[0];
            for (var i=1; i<intervals.length; i++) {
                if (intervals[i][0] >= currentPair[1]) {
                    currentPair = intervals[i];
                }
                else {
                    removal++;
                    if (currentPair[1] > intervals[i][1]) {
                        currentPair = intervals[i];
                    }
                }
            }
        }
        return removal;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][] {{1,2}, {2,3},{3,4},{1,3}}));
        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{1,2},{1,2}}));
        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{2,3}}));
    }
}
