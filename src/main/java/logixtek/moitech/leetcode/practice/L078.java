package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L078 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.emptyList());
        find(nums, list, new ArrayList<>(), 0);
        return list;
    }

    private static void find(int[] nums, List<List<Integer>> list, List<Integer> item, int index) {
        for (int i = index; i < nums.length; i++) {
            item.add(nums[i]);
            list.add(new ArrayList<>(item));
            find(nums, list, item, i + 1);
            item.remove(item.size() - 1);
        }
    }
}
