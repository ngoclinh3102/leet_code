package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L905 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(23, 7, 42, 15, 34, 10, 5, 48, 19, 2)));
        System.out.println(Arrays.toString(sortArrayByParity(1, 2)));
        System.out.println(Arrays.toString(sortArrayByParity(2, 1)));

    }

    public static int[] sortArrayByParity(int... nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 0) i++;
            while (i < j && nums[j] % 2 == 1) j--;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
        return nums;
    }
}
