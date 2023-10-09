package logixtek.moitech.leetcode.practice;

public class L287 {

    public static void main(String[] args) {
    }

    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (true) {
            if (nums[i] == 0) return i;
            int temp = nums[i];
            nums[i] = 0;
            i = temp;
        }
    }
}
