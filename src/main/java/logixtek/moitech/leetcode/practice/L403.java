package logixtek.moitech.leetcode.practice;

import java.util.HashMap;
import java.util.HashSet;

public class L403 {
    public static void main(String[] args) {
        System.out.println(canCross(0,1,3,5,6,8,12,17));
    }

    public static boolean canCross(int... stones) {
        int n = stones.length;
        if (n > 1 && stones[1] != 1) return false;

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        map.get(1).add(1);
        for (int i = 1; i < n; i++) {
            if (map.get(stones[i]).size() == 0) continue;

            for (int step : map.get(stones[i])) {
                int next = stones[i] + step - 1;

                if (next > stones[i] && map.containsKey(next)) map.get(next).add(step-1);
                if (map.containsKey(++next)) map.get(next).add(step);
                if (map.containsKey(++next)) map.get(next).add(step+1);
            }
        }

        return map.get(stones[n-1]).size() > 0;
    }
}
