package logixtek.moitech.leetcode.practice;

public class L053 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(-1)); // -1
        System.out.println(maxSubArray(1)); // 1
        System.out.println(maxSubArray(-2,1,-3,4,-1,2,1,-5,4)); // 6
        System.out.println(maxSubArray(5,4,-1,7,8)); // 23
    }

    public static int maxSubArray(int... nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            currentSum = Math.max(0, currentSum);
        }
        return maxSum;
    }
}
