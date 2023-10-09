package logixtek.moitech.leetcode.practice;

public class L041 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(1,2,0)); // 3
        System.out.println(firstMissingPositive(3,4,-1,1)); // 2
        System.out.println(firstMissingPositive(5,6,7,8,9)); // 1
        System.out.println(firstMissingPositive(0,1,2,3)); // 4
        System.out.println(firstMissingPositive(1,2,3)); // 4
        System.out.println(firstMissingPositive(1,1,2,3)); // 4
    }

    public static int firstMissingPositive(int... nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
            else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }
}
