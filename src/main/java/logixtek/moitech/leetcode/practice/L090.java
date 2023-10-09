package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L090 {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {0}));
        System.out.println(subsetsWithDup(new int[] {1,2,2}));
        System.out.println(subsetsWithDup(new int[] {4,4,4,1,4}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.emptyList());
        Arrays.sort(nums);
        find(nums, list, new ArrayList<>(), 0);
        return list;
    }

    private static void find(int[] nums, List<List<Integer>> list, List<Integer> item, int index) {
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            item.add(nums[i]);
            list.add(new ArrayList<>(item));
            find(nums, list, item, i + 1);
            item.remove(item.size() - 1);
        }
    }
}
