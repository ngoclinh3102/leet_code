package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L034 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 3)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 6)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstIndex = binarySearchFirstIndex(nums, target);
        if (firstIndex != -1) {
            int lastIndex = binarySearchLastIndex(nums, firstIndex, nums.length - 1, target);
            if (lastIndex != -1) {
                return new int[]{firstIndex, lastIndex};
            }
        }
        return new int[]{-1, -1};
    }

    private static int binarySearchFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int middle;
        while (left < right) {
            middle = (left + right) / 2;

            if (nums[middle] >= target) right = middle;
            else left = middle + 1;
        }

        return left < nums.length && nums[left] == target ? left : -1;
    }

    private static int binarySearchLastIndex(int[] nums, int left, int right, int target) {
        int middle;
        while (left < right) {
            middle = (left + right + 1) / 2;
            if (nums[middle] == target) left = middle;
            else right = middle - 1;
        }
        return right;
    }
}
