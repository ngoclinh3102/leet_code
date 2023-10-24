package logixtek.moitech.leetcode.practice;

public class L154 {

    public static void main(String[] args) {

    }

    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }
}
