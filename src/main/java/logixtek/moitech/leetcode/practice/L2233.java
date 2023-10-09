package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L2233 {

    public static void main(String[] args) {
//        System.out.println(maximumProduct(new int[]{0,4}, 5)); // 20
//        System.out.println(maximumProduct(new int[]{6,3,3,2}, 2)); // 216
        System.out.println(maximumProduct(new int[]{14,235,4326,265,6246,2436}, 1513)); // 718920727
    }

    public static int maximumProduct(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 0;
        while (k-- > 0) {
            nums[index]++;
            if (index + 1 < nums.length && nums[index] > nums[index + 1]) index++;
            else index = 0;
        }
        index = 0;
        long product = nums[index++];
        while (index < nums.length) {
            product *= nums[index++];
            product = product % 1_000_000_007;
        }
        return (int) product;
    }
}
