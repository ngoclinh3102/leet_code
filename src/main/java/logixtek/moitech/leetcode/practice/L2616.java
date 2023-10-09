package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L2616 {

    public static void main(String[] args) {
        System.out.println(minimizeMax(new int[] {10,1,2,7,1,3}, 2));
        System.out.println(minimizeMax(new int[] {4,2,1,2}, 1));
    }

    public static int minimizeMax(int[] nums, int p) {
        if (nums.length == 0 || p == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int middle = (left + right) / 2;
            if (countPairs(nums, middle) >= p) {
                right = middle;
            }
            else {
                left = middle + 1;
            }
        }

        return left;
    }

    private static int countPairs(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i+1] - nums[i] <= diff) {
                count++;
                i++;
            }
        }
        return count;
    }
}
