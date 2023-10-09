package logixtek.moitech.leetcode.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L239 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))); // [3,3,5,5,6,7]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1))); // [1]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,-1}, 1))); // [1,-1]
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() + k <= i) deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
            deque.offerLast(i);
            if (!deque.isEmpty() && i + 1 >= k) ans[i + 1 - k] = Math.max(nums[i], nums[deque.peekFirst()]);
        }

        return ans;
    }
}
