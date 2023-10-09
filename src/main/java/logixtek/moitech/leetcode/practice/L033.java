package logixtek.moitech.leetcode.practice;

public class L033 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));    // 4
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));    // -1
        System.out.println(search(new int[]{1}, 0));                // -1
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));    // 4
        System.out.println(search(new int[]{3, 1}, 1));              // 1
        System.out.println(search(new int[]{3, 1}, 3));              // 0
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (nums[left] > nums[right]) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[left]) {
                left = middle;
            }
            else {
                right = middle;
            }
        }

        return nums[0] <= target
               ? binarySearch(nums, target, 0, right)
               : binarySearch(nums, target, right + 1, nums.length - 1);
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {
        while (start < end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            else if (nums[middle] < target) {
                start = middle + 1;
            }
            else {
                end = middle;
            }
        }
        return start < nums.length && nums[start] == target ? start : -1;
    }
}
