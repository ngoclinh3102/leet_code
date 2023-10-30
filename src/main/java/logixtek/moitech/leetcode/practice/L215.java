package logixtek.moitech.leetcode.practice;

import java.util.PriorityQueue;

public class L215 {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2)); // 5
        System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4)); // 4
        System.out.println(findKthLargest(new int[] {7,6,5,4,3,2,1}, 2)); // 6
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while (i < k) {
            pq.add(nums[i++]);
        }
        while (i < n) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
            i++;
        }
        return pq.peek();
    }
}
