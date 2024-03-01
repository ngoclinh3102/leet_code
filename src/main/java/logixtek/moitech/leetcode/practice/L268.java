package logixtek.moitech.leetcode.practice;

public class L268 {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int number : nums) sum += number;
        return (nums.length * (nums.length + 1) / 2) - sum;
    }
}
