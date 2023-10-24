package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L047 {

    public static void main(String[] args) {
        // TODO
        int[] nums = {1,2,3,4,5,6};
        for (var item : permuteUnique(nums)) {
            System.out.println(item);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        permute(list, new ArrayList<>(), nums);
        return list;
    }

    private static void permute(List<List<Integer>> list, List<Integer> item, int[] nums) {
        if (item.size() == nums.length) {
            list.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || !item.contains(nums[i]) && nums[i] != nums[i-1]) {
                item.add(nums[i]);
                permute(list, item, nums);
                item.remove(item.size() - 1);
            }
        }
    }
}
