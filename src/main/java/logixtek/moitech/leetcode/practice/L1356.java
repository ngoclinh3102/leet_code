package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L1356 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits(0, 1, 2, 3, 4, 5, 6, 7, 8)));
        System.out.println(Arrays.toString(sortByBits(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1)));
    }

    public static int[] sortByBits(int... arr) {
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) nums[i] = arr[i];

        Arrays.sort(nums, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);
            return bitCountA != bitCountB ? bitCountA - bitCountB : a - b;
        });

        for (int i = 0; i < arr.length; i++) arr[i] = nums[i];
        return arr;
    }
}
