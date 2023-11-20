package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L1877 {
    public static void main(String[] args) {
        // TODO ~ Improve: count sort
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int mps = 0;
        for (int i = nums.length/2; i < nums.length; i++) {
            mps = Math.max(mps, nums[i] + nums[nums.length-i-1]);
        }

        return mps;
    }
}
