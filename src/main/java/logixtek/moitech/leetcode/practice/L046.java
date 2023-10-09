package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class L046 {

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static List<Integer> toList(int[] nums) {
        var temp = new ArrayList<Integer>();
        for (int num : nums) {
            temp.add(num);
        }
        return temp;
    }

    private static void permute(List<List<Integer>> list, int[] nums, int cur) {
        if (cur == nums.length) {
            list.add(toList(nums));
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            swap(nums, cur, i);
            permute(list, nums, cur + 1);
            swap(nums, cur, i);
        }
    }

    private static void permute2(List<List<Integer>> list, List<Integer> item, int[] nums) {
        if (item.size() == nums.length) {
            list.add(new ArrayList<>(item));
            return;
        }
        for (int num : nums) {
            if (!item.contains(num)) {
                item.add(num);
                permute2(list, item, nums);
                item.remove(item.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
//        permute(list, nums, 0);
        permute2(list, new ArrayList<>(), nums);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        for (var item : permute(nums)) {
           System.out.println(item);
        }
    }
}
