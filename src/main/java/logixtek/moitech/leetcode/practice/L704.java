package logixtek.moitech.leetcode.practice;

public class L704 {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length > 0) {
            while (left < right) {
                int middle = (left + right) / 2;
                if (nums[middle] == target) return middle;
                else if (nums[middle] < target) left = middle + 1;
                else right = middle;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {0,1,2,3,4,5,6,7,8,9}, 7));
    }
}
