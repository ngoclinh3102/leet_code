package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L040 {
    public static void main(String[] args) {
        int[] candidates = new int[]{
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(combinationSum2(candidates, 30));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> combinations = new ArrayList<>();

        combine(combinations, candidates, target, new ArrayList<>(), 0, 0);

        return combinations;
    }

    private static void combine(List<List<Integer>> combinations, int[] candidates, int target,
                                List<Integer> item, int sum, int from) {
        if (sum == target) {
            combinations.add(new ArrayList<>(item));
            return;
        }

        int lastRemoved = 0;
        for (int i = from; i < candidates.length; i++) {
            if (sum + candidates[i] > target) return;
            if (candidates[i] == lastRemoved) continue;

            item.add(candidates[i]);
            combine(combinations, candidates, target, item, sum + candidates[i], i + 1);
            lastRemoved = item.remove(item.size()-1);
        }
    }
}
