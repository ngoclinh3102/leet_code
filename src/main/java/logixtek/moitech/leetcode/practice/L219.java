package logixtek.moitech.leetcode.practice;

import java.util.HashMap;

public class L219 {

    public static void main(String[] args) {
        // TODO: Contains Duplicate III
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], valueDiff + 1);
            if (map.containsKey(m)) return true;
            if (map.containsKey(m - 1) && Math.abs(nums[i] - map.get(m - 1)) <= valueDiff) return true;
            if (map.containsKey(m + 1) && Math.abs(nums[i] - map.get(m + 1)) <= valueDiff) return true;

            map.put(m, (long) nums[i]);
            if (i >= indexDiff) map.remove(getID(nums[i - indexDiff], valueDiff + 1));
        }
        return false;
    }

    private long getID(long i, long range) {
        return i < 0 ? (i + 1) / range - 1 : i / range;
    }
}
