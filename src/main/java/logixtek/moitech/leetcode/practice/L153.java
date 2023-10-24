package logixtek.moitech.leetcode.practice;

import java.util.HashSet;

public class L153 {

    public static void main(String[] args) {
        System.out.println(findMin(3,4,5,1,2)); // 1
        System.out.println(findMin(4,5,6,7,0,1,2)); // 0
        System.out.println(findMin(11,13,15,17)); // 11
    }

    public static int findMin(int... nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid;
            }
            else if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                right = mid;
            }
            else {
                            HashSet<Integer> set = new HashSet<>();
                return Math.min(nums[left], nums[right]);
            }
        }

        return left + 1 < nums.length ? nums[left+1] : nums[0];
    }
}
