package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L039 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new LinkedList<>();
        combine(combinations, candidates, target, new LinkedList<>(), 0, 0);
        return combinations;
    }

    private static void combine(List<List<Integer>> combinations, int[] candidates, int target,
                                LinkedList<Integer> item, int sum, int from)
    {
        if (sum == target) {
            combinations.add(new LinkedList<>(item));
        }

        for (int i = from; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;

            item.addLast(candidates[i]);
            combine(combinations, candidates, target, item, sum + candidates[i], i);
            item.removeLast();
        }
    }
}
