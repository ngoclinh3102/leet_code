package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L977 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(-4,-1,0,3,10)));
        System.out.println(Arrays.toString(sortedSquares(-7,-3,2,3,11)));
        System.out.println(Arrays.toString(sortedSquares(-4,-4,-3)));
    }

    public static int[] sortedSquares(int... nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] answer = new int[nums.length];
        for (int k = nums.length - 1; k >= 0; k--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                answer[k] = nums[i] * nums[i];
                i++;
            }
            else {
                answer[k] = nums[j] * nums[j];
                j--;
            }
        }

        return answer;
    }

    public static int[] sortedSquares2(int... nums) {
        int i = 0;
        while (i + 1 < nums.length && Math.abs(nums[i]) >= Math.abs(nums[i+1])) i++;

        int j = i + 1;
        int[] answer = new int[nums.length];

        for (int k = 0; k < nums.length; k++) {
            if ((i >= 0 && j < nums.length && Math.abs(nums[i]) < Math.abs(nums[j])) || j >= nums.length) {
                answer[k] = nums[i] * nums[i];
                i--;
            }
            else {
                answer[k] = nums[j] * nums[j];
                j++;
            }
        }

        return answer;
    }
}
