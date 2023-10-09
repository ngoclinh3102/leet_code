package logixtek.moitech.leetcode.practice;

public class L027 {

    public static void main(String[] args) {
        System.out.println(new L027().removeElement(new int[] {3,3,3}, 2)); // 3
        System.out.println(new L027().removeElement(new int[] {3,2,2,3,2}, 2)); // 2
        System.out.println(new L027().removeElement(new int[] {0,1,2,2,3,0,4,2}, 2)); // 5
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int temp;
        while (i < j) {
            while (i < j && nums[i] != val) i++;
            if (nums[i] == val) {
                while (i < j && nums[j] == val) j--;
                if (nums[j] != val) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            i++;
            j--;
        }

        j = nums.length - 1;
        while (j >= 0 && nums[j] == val) j--;
        return j + 1;
    }
}
