package logixtek.moitech.leetcode.practice;

public class L410 {
    public static void main(String[] args) {
        int[] nums = {10,5,13,4,8,4,5,11,14,9,16,10,20,8}; // 137 ~ 17
        System.out.println(splitArray(nums, 8));
    }

    public static int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int e : nums) {
            low = Math.max(low, e);
            high += e;
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canSplit(nums, k, mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }

    private static boolean canSplit(int[] nums, int k, int middle) {
        int sum = 0;
        int numOfParts = 0;
        for (int e : nums) {
            sum += e;
            if (sum > middle) {
                sum = e;
                numOfParts++;
            }
        }
        return numOfParts >= k;
    }
}
