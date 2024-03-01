package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L2966 {
    public static void main(String[] args) {

    }

    public int[][] divideArray(int[] nums, int k) {
        int[][] answer = new int[nums.length/3][3];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i] + k >=  nums[i+2]) {
                answer[i/3][0] = nums[i];
                answer[i/3][1] = nums[i+1];
                answer[i/3][2] = nums[i+2];
            }
            else {
                return new int[][]{};
            }
        }

        return answer;
        // [1,4,1,5,7,3,6,1,9,9,3]
        // [1,7,7,7,7,9,9,9,9,9,9]
    }
}
