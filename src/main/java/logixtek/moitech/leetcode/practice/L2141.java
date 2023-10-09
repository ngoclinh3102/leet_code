package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L2141 {

    public static long maxRunTime(int n, int[] batteries) {
        if (batteries.length == n) {
            int min = batteries[0];
            for (int i : batteries) {
                if (min > i) {
                    min = i;
                }
            }
            return min;
        }

        long runtime = 0;
        while (true) {
            Arrays.sort(batteries);
            if (batteries[batteries.length - n] > 0) {
                runtime += 1;
                for (int i = 1; i <= n; i++) {
                    batteries[batteries.length - i] -= 1;
                }
            }
            else {
                break;
            }
        }

        return runtime;
    }

    public static long maxRunTime2(int n, int[] batteries) {
        long left = 1;
        long right = Arrays.stream(batteries).asLongStream().sum() / n;
        while (left < right) {
            long target = right - (right - left) / 2;
            long total = Arrays.stream(batteries).asLongStream().map(battery -> Math.min(battery, target)).sum();
            if (total >= target * n) {
                left = target;
            } else {
                right = target - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // Test cases
//        System.out.println(maxRunTime(2, new int[]{31,87,85,44,47,25})); // 159
//        System.out.println(maxRunTime(3, new int[]{10,10,5,3})); // 8
//        System.out.println(maxRunTime(4, new int[]{8,1,4,8})); // 1
//        System.out.println(maxRunTime(2, new int[]{3,3,3})); // 4
        System.out.println(maxRunTime2(12, new int[]{11,89,16,32,70,67,35,35,31,24,41,29,6,53,78,83})); // 43
    }
}