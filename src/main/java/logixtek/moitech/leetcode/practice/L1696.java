package logixtek.moitech.leetcode.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class L1696 {

    public static void main(String[] args) {
        System.out.println(maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2)); // 7
        System.out.println(maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3)); // 17
        System.out.println(maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2)); // 0
    }

    public static int maxResult(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);

        for (int i = 1; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.getFirst() + k < i) deque.removeFirst();

            nums[i] += nums[deque.getFirst()];

            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) deque.removeLast();

            deque.addLast(i);
        }

        return nums[nums.length-1];
    }
}
