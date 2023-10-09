package logixtek.moitech.leetcode.practice;

public class L896 {

    public static void main(String[] args) {
    }

    public static boolean isMonotonic(int... nums) {
        if (nums.length <= 2) return true;

        if (nums[0] < nums[nums.length-1]) {
            for (int i = 0; i + 1 < nums.length; i++) {
                if (nums[i] > nums[i+1]) {
                    return false;
                }
            }
            return true;
        }

        if (nums[0] > nums[nums.length-1]) {
            for (int i = 0; i + 1 < nums.length; i++) {
                if (nums[i] < nums[i+1]) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] != nums[i+1]) {
                return false;
            }
        }
        return true;
    }
}
