package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.HashMap;

public class L823 {

    public static void main(String[] args) {
        System.out.println(numFactoredBinaryTrees(2,4));
    }

    public static int numFactoredBinaryTrees(int... arr) {
        final int MODULO = 1_000_000_007;
        HashMap<Integer, Long> map = new HashMap<>();

        Arrays.sort(arr);

        long totalTree = 0;
        for (int i = 0; i < arr.length; i++) {
            long count = 1;
            for (int j = 0; j < i && arr[j] <= Math.sqrt(arr[i]); j++) {
                int k;
                if (arr[i] % arr[j] == 0 && map.containsKey(k = arr[i] / arr[j])) {
                    count += (map.get(arr[j]) * map.get(k) * (arr[j] != k ? 2 : 1));
                    count %= MODULO;
                }
            }
            map.put(arr[i], count);
            totalTree += count;
            totalTree %= MODULO;
        }

        return (int) totalTree;
    }
}
