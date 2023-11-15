package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L1846 {
    public static void main(String[] args) {

    }

    public static int maximumElementAfterDecrementingAndRearranging(int... nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] counts = new int[n+1];

        for (int e : nums) {
            counts[Math.min(e, n)]++;
        }

        int max = n;
        int countOfBigger = 0;

        for (int i = n; i > 0; i--) {
            if (counts[i] > 0) {
                countOfBigger += (counts[i] - 1);
            }
            else {
                if (countOfBigger == 0) {
                    max--;
                }
                else {
                    countOfBigger--;
                }
            }
        }

        return max;
    }
}
