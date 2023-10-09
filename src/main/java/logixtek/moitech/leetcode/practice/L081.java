package logixtek.moitech.leetcode.practice;

public class L081 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1}, 13)); // true
        System.out.println(search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2)); // true
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3)); // false
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0)); // true
        System.out.println(search(new int[]{1}, 1)); // true
    }

    public static boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }
}
