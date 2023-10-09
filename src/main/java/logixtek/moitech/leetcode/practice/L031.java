package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L031 {

    public static void main(String[] args) {
        int[][] numss = {
                {1, 2, 3}, // 1.3.2
                {1, 3, 2}, // 2.1.3
                {2, 3, 1}, // 3.1.2
                {3, 2, 1}, // 1.2.3
                {1, 1, 5}, // 1.5.1
                {2, 3, 1, 3, 3}, // 2,3,3,1,3
        };
        for (int[] nums : numss) {
            System.out.println(Arrays.toString(nums));
            nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length - 1;
        while (n > 0) {
            if (nums[n] > nums[n - 1]) {
                break;
            }
            n--;
        }

        if (n > 0) {
            int replaceIndex = minReplaceable(nums, n);
            swap(nums, n-1, replaceIndex);
        }

        revert(nums, n);
    }

    private static int minReplaceable(int[] nums, int from) {
        int key = nums[from - 1];
        int replaceableIndex = from;

        for (int i = from; i < nums.length; i++) {
            if (nums[i] <= nums[replaceableIndex] && nums[i] > key) {
                replaceableIndex = i;
            }
        }

        return replaceableIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void revert(int[] nums, int from) {
        int startIndex = from;
        int endIndex = nums.length - 1;

        while (startIndex < endIndex) {
            swap(nums, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }
}
