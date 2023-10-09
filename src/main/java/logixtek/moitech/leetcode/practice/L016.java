package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L016 {
    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(threeSumClosest(nums, -2)); // -2
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 1_000_000;
        for (int i = 0; i + 2 < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(closest - target)) closest = sum;

                if (sum < target) {
                    j++;
                    while (i + 1 < k && nums[j+1] == nums[j]) j++;
                }
                else {
                    k--;
                    while (k + 1 < j && nums[k-1] == nums[k]) k--;
                }
            }
            while (i + 3 < nums.length && nums[i+1] == nums[i]) i++;
        }
        return closest;
    }
}
