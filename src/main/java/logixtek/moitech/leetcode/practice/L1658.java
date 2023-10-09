package logixtek.moitech.leetcode.practice;

public class L1658 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,4,2,3};
        System.out.println(minOperations2(nums, 5)); // 2
    }

    public static int minOperations2(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum == x) return nums.length;

        int minOperations = nums.length + 1;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum -= nums[j];
            while (i <= j && sum < x) {
                sum += nums[i];
                i++;
            }
            if (sum == x) {
                minOperations = Math.min(minOperations, i + (nums.length - j - 1));
            }
        }

        return minOperations <= nums.length ? minOperations : -1;
    }

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        long[] leftSum = new long[n+1];
        long[] rightSum = new long[n+1];

        for (int i = 1; i <= n; i++) leftSum[i] = nums[i-1] + leftSum[i-1];
        for (int i = n-1; i >= 0; i--) rightSum[i] = nums[i] + rightSum[i+1];

        int minOP = n + 1;
        for (int left = 0; left <= n; left++) {
            int right = binarySearch(rightSum, left + 1, n, x - leftSum[left]);
            if (right != -1) {
                minOP = Math.min(minOP, left + (n-right));
            }
        }

        return minOP <= n ? minOP : -1;
    }

    /** Binary Search In Decreasing Array **/
    private static int binarySearch(long[] sarray, int start, int end, long target) {
        while (start < end) {
            int middle = (start + end) / 2;
            if (sarray[middle] > target) start = middle + 1;
            else end = middle;
        }
        return sarray[end] == target ? end : -1;
    }
}
