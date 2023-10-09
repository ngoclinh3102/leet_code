package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class L2439 {

    public static int minimizeArrayValue(int[] nums) {
        int sum = IntStream.of(nums).sum();

        int right = IntStream.of(nums).max().orElse(0);
        int left = (int) Math.ceil(sum * 1.0 / nums.length);

        while (left < right) {
            int target = (right + left) / 2;
            if (check(nums, target)) {
                right = target;
            }
            else {
                left = target + 1;
            }
        }

        return left;
    }

    private static boolean check(int[] nums, long k) {
        if (nums[0] > k) {
            return  false;
        }
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > (k * (i+1))) {
                return false;
            }
        }
        return true;
    }

    public static int minimizeArrayValue2(int[] nums) {
        int ans = (int) Math.ceil((double) Arrays.stream(nums).sum() / nums.length);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = (int) Math.max(ans, (sum + i) / (i + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimizeArrayValue2(new int[] {10,1})); // 10
        System.out.println(minimizeArrayValue2(new int[] {3,7,1,6})); // 5
        System.out.println(minimizeArrayValue2(new int[] {13,13,20,0,8,9,9})); // 16
    }
}
