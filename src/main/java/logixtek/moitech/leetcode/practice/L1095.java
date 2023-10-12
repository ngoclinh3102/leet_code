package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.MountainArray;

import java.util.Arrays;

public class L1095 {

    public static void main(String[] args) {    }

    public static int findInMountainArray(int target, MountainArray mountain) {
        int peak = peakIndexInMountainArray(mountain);

        int leftSearch = binarySearchIncr(mountain, target, peak);

        if (leftSearch != -1) {
            return leftSearch;
        }

        return binarySearchDecr(mountain, target, peak);
    }

    public static int peakIndexInMountainArray(MountainArray mountain) {
        int left = 0;
        int right = mountain.length() - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (mountain.get(mid) < mountain.get(mid+1)) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return left;
    }

    private static int binarySearchIncr(MountainArray mountain, int target, int peak) {
        int left = 0;
        int right = peak;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = mountain.get(mid);

            if (midVal == target) {
                return mid;
            }

            if (midVal < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private static int binarySearchDecr(MountainArray mountain, int target, int peak) {
        int left = peak;
        int right = mountain.length() - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = mountain.get(mid);

            if (midVal == target) {
                return mid;
            }

            if (midVal > target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
