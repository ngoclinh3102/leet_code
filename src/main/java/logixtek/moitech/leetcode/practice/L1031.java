package logixtek.moitech.leetcode.practice;

public class L1031 {

    public static void main(String[] args) {
        System.out.println(maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2)); // 20
        System.out.println(maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2)); // 29
        System.out.println(maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3)); // 31
        System.out.println(maxSumTwoNoOverlap(new int[]{8, 20, 6, 2, 20, 17, 6, 3, 20, 8, 12}, 5, 4)); // 108
    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;

        int[] firstSum = slidingGenerate(nums, firstLen);
        int[] secondSum = slidingGenerate(nums, secondLen);

        int[] firstMax = new int[n];
        int[] secondMax = new int[n];

        firstMax[n - 1] = firstSum[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            firstMax[i] = Math.max(firstSum[i], firstMax[i + 1]);
        }

        secondMax[n - 1] = secondSum[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            secondMax[i] = Math.max(secondSum[i], secondMax[i + 1]);
        }

        int maxSum = 0;
        for (int i = 0; i + firstLen < n; i++) {
            maxSum = Math.max(maxSum, firstSum[i] + secondMax[i + firstLen]);
        }
        for (int i = 0; i + secondLen < n; i++) {
            maxSum = Math.max(maxSum, secondSum[i] + firstMax[i + secondLen]);
        }

        return maxSum;
    }

    private static int[] slidingGenerate(int[] nums, int len) {
        int[] array = new int[nums.length];
        for (int i = 0; i < len; i++) {
            array[0] += nums[i];
        }
        for (int i = 1; i + len - 1 < nums.length; i++) {
            array[i] = array[i - 1] - nums[i - 1] + nums[i - 1 + len];
        }
        return array;
    }
}
