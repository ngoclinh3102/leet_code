package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L039 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        combine(combinations, candidates, target, new ArrayList<>(), 0, 0);
        return combinations;
    }

    private static void combine(List<List<Integer>> combinations, int[] candidates, int target,
                                ArrayList<Integer> item, int sum, int from)
    {
        if (sum == target) {
            combinations.add(new ArrayList<>(item));
            return;
        }

        for (int i = from; i < candidates.length; i++) {
            if (sum + candidates[i] > target) return;

            item.add(candidates[i]);
            combine(combinations, candidates, target, item, sum + candidates[i], i);
            item.remove(item.size()-1);
        }
    }
}
