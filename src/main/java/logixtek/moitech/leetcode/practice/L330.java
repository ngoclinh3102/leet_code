package logixtek.moitech.leetcode.practice;

import org.springframework.stereotype.Component;

@Component("HARD")
public class L330 {
    public static void main(String[] args) {
        int[] nums = {1,2,31,33};
        System.out.println(minPatches(nums, 2_147_483_647));
    }

    public static int minPatches(int[] nums, int n) {
        int count = 0;

        int i = 0;
        long number = 1;
        while (number <= n) {
            if (i < nums.length && nums[i] <= number) {
                number += nums[i++];
            }
            else {
                count++;
                number *= 2;
            }
        }
        return count;
    }
}
