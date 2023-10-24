package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L047 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        for (var item : permuteUnique(nums)) {
            System.out.println(item);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] isUsed = new boolean[nums.length];
        List<List<Integer>> list = new ArrayList<>();
        permute(nums, list, isUsed, new ArrayList<>());
        return list;
    }

    private static void permute(int[] nums, List<List<Integer>> list, boolean[] isUsed, List<Integer> item) {
        if (item.size() == nums.length) {
            list.add(new ArrayList<>(item));
            return;
        }

        int lastRemoved = 99;
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i] && nums[i] != lastRemoved) {
                item.add(nums[i]);
                isUsed[i] = true;

                permute(nums, list, isUsed, item);

                lastRemoved = item.remove(item.size() - 1);
                isUsed[i] = false;
            }
        }
    }
}
