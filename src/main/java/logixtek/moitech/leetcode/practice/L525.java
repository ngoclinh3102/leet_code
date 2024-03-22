package logixtek.moitech.leetcode.practice;

import java.util.HashMap;

public class L525 {
    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {
        int[] count = new int[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count[i+1] = count[i] + (nums[i] == 1 ? 1 : -1);
            map.put(count[i+1], i);
        }

        int res = 0;
        for (int i = 0; i < count.length; i++) {
            res = Math.max(res, map.getOrDefault(count[i], -100_000) - i + 1);
        }

        return res;
    }
}
