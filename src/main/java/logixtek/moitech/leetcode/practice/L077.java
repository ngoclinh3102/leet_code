package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class L077 {

    private static final List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        for (int i = n; i >= k; i--) {
            combineItem(new ArrayList<>(), i, k);
        }
        return list;
    }

    private static void combineItem(List<Integer> item, int i, int k) {
        item.add(i);
        if (k == 1) {
            list.add(item);
            return;
        }
        for (int j = i - 1; j > 0; j--) {
            combineItem(new ArrayList<>(item), j, k - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(5,3));
    }
}
