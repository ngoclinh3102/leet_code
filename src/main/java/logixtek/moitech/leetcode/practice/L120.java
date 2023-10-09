package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.List;

public class L120 {

    public static void main(String[] args) {
        System.out.println(minimumTotal(
                Arrays.asList(
                        Arrays.asList(2),
                        Arrays.asList(3, 4),
                        Arrays.asList(6, 5, 7),
                        Arrays.asList(4, 1, 8, 3)
                )
        ));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size() - 2;

        while (n >= 0) {
            for (int i = 0; i < triangle.get(n).size(); i++) {
                triangle.get(n).set(i, triangle.get(n).get(i) + Math.min(triangle.get(n+1).get(i), triangle.get(n+1).get(i+1)));
            }
            n--;
        }

        for (List<Integer> list : triangle) System.out.println(list);

        return triangle.get(0).get(0);
    }
}
