package logixtek.moitech.leetcode.practice;

public class L169 {

    public static void main(String[] args) {
        System.out.println(majorityElement(2,2,1,1,1,2,2));
    }

    public static int majorityElement(int... nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            }
            else if (major == nums[i]) {
                count++;
            }
            else {
                count--;
            }
        }
        return major;
    }
}
