package logixtek.moitech.leetcode.practice;

public class L035 {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            else if (nums[middle] > target) right = middle;
            else left = middle + 1;
        }
        return nums.length == 0  || nums[nums.length - 1] >= target
               ? left
               : left + 1;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1}, 1));
    }
}
