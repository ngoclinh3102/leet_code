package logixtek.moitech.leetcode.practice;

/**
 * @author ngoclinh
 */
public class L3381 {
    public long maxSubarraySum(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        long[] arr = new long[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }

    }
}
