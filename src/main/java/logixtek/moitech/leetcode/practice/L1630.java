package logixtek.moitech.leetcode.practice;

import java.util.*;

public class L1630 {
    public static void main(String[] args) {
        System.out.println(checkArithmeticSubarrays(new int[]{4,6,5,9,3,7}, new int[]{0,0,2}, new int[]{2,3,5}));
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            list.add(check(nums, l[i], r[i]));
        }
        return list;
    }

    private static boolean check(int[] nums, int start, int end) {
        int min = nums[end];
        int max = nums[end];

        for (int i = start; i < end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if (max == min) return true;
        if (((max - min) % (end - start)) != 0) return false;

        int diff = (max - min) / (end - start);
        boolean[] rearranged = new boolean[end - start + 1];

        for (int i = start; i <= end; i++) {

            if ((nums[i] - min) % diff != 0) return false;

            int index = (nums[i] - min) / diff;
            if (rearranged[index]) return false;

            rearranged[index] = true;
        }

        return true;
    }
}
