package logixtek.moitech.leetcode.practice;

public class L2366 {

    public static void main(String[] args) {
        System.out.println(minimumReplacement(3,9,3)); // 2
        System.out.println(minimumReplacement(7,6,15,6,11,14,10)); // 10
        System.out.println(minimumReplacement(260,346,22)); // 27
    }

    public static long minimumReplacement(int... nums) {
        long count = 0;
        int index = nums.length - 2;

        while (index >= 0) {
            if (nums[index] > nums[index + 1]) {
                int k = (nums[index] + nums[index + 1] - 1) / nums[index + 1];
                nums[index] /= k;
                count += (k-1);
            }
            index--;
        }

        return count;
    }
}
