package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L2099 {

    public static void main(String[] args) {
        int[] nums = {7,1,5,2,4,6,3};
        System.out.println(Arrays.toString(maxSubsequence(nums, 3)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        boolean[] isMaxSequence = new boolean[nums.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> nums[a]));
        for (int i = 0; i < k; i++) {
            queue.add(i);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[queue.peek()] < nums[i]) {
                queue.poll();
                queue.add(i);
            }
        }
        return nums;
    }
}
