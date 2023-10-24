package logixtek.moitech.leetcode.practice;

public class L154 {

    public static void main(String[] args) {

    }

    public static int findMin(int[] nums) {
        return findMinInRange(nums, 0, nums.length - 1);
    }

    private static int findMinInRange(int[] nums, int left, int right) {
        int mid = (left + right) >>> 1;
        return 0;
    }
}
