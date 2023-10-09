package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L018 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> listSum = new ArrayList<>();
        for (int a = 0; a + 3 < nums.length; a++) {
            for (int b = a + 1; b + 2 < nums.length; b++) {
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    long sum = (long) (nums[a] + nums[b]) + nums[c] + nums[d];

                    if (sum < target) {
                        c++;
                    }
                    else if (sum > target) {
                        d--;
                    }
                    else {
                        listSum.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;
                        while (c < d && nums[c] == nums[c-1]) c++;
                        while (d > c && nums[d] == nums[d+1]) d--;
                    }
                }
                while (b + 1 < nums.length && nums[b+1] == nums[b]) b++;
            }
            while (a + 1 < nums.length && nums[a+1] == nums[a]) a++;
        }

        return listSum;
    }
}
