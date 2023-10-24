package logixtek.moitech.leetcode.practice;

public class L1793 {

    public static void main(String[] args) {
        System.out.println(maximumScore(3, 1,4,3,7,4,5)); // 15
        System.out.println(maximumScore(0, 5,5,4,5,4,1,1,1)); // 20
    }

    public static int maximumScore(int k, int... nums) {
        int i = k;
        int j = k;
        int min = nums[k];
        int score = nums[k];

        while (i > 0 && j + 1 < nums.length) {
            min = Math.min(min, (nums[i-1] > nums[j+1]) ? nums[--i] : nums[++j]);
            score = Math.max(score, min * (j-i+1));
        }

        while (i > 0) {
            min = Math.min(min, nums[--i]);
            score = Math.max(score, min * (j-i+1));
        }

        while (j + 1 < nums.length) {
            min = Math.min(min, nums[++j]);
            score = Math.max(score, min * (j-i+1));
        }

        return score;
    }
}
