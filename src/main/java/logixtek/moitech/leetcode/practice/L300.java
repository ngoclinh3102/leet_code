package logixtek.moitech.leetcode.practice;

public class L300 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(1,7,8,4,5,6,-1,9));
    }

    public static int lengthOfLIS(int... nums) {
        int lis = 0;
        for (int num : nums) {
            int left = 0;
            int right = lis;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < num) left = mid + 1;
                else right = mid;
            }
            nums[left] = num;
            if (left == lis) lis++;
        }

        return lis;
    }
}
