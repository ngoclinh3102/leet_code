package logixtek.moitech.leetcode.practice;

import java.util.PriorityQueue;

public class L2971 {

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{5,5,5}));
    }

    public static long largestPerimeter(int[] nums) {
        long sum = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) {
            sum += n;
            priorityQueue.offer(n);
        }

        while (priorityQueue.size() > 2) {
            int number = priorityQueue.poll();
            if (sum > 2L * number) {
                return sum;
            }
            sum -= number;
        }

        return -1;
    }
}