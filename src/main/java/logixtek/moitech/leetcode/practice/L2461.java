package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

/**
 * @author ngoclinh
 */
public class L2461 {

    public static final L2461 Instance = new L2461();

    public long maximumSubarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        int[] lastSeen = new int[100_000];
        Arrays.fill(lastSeen, -k-1);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i - lastSeen[num] <= k) {
                nums[lastSeen[num]] = 0;
            }
            lastSeen[num] = i;
        }

        int count = 0;
        int prevError = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                prevError = i;
            }
            else if (i - prevError >= k) {
                count++;
            }
        }

        return count;
    }
}
