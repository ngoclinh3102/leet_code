package logixtek.moitech.leetcode.practice;

import java.util.HashMap;

public class L1814 {
    public static void main(String[] args) {
        System.out.println(countNicePairs(42,11,1,97));
    }

    public static int countNicePairs(int... nums) {
        final int MOD = 1_000_000_007;
        HashMap<Integer, Integer> map = new HashMap<>();

        long count = 0;

        for (int num : nums) {
            int origin = num;
            int rev = 0;
            while (origin > 0) {
                rev = 10 * rev + origin % 10;
                origin /= 10;
            }

            int diff = num - rev;
            int numOfPair = map.getOrDefault(diff, 0);

            count += numOfPair;
            map.put(diff, numOfPair + 1);
        }

        return (int) (count % MOD);
    }
}
