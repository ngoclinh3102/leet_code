package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L026 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(1,1,2)); // 2
        System.out.println(removeDuplicates(0,0,1,1,1,2,2,3,3,4)); // 5
    }

    public static int removeDuplicates(int... nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[index + 1] = nums[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return index + 1;
    }
}
