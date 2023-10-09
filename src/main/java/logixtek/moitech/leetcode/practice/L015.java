package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L015 {

    public static void main(String[] args) {
        var threeSums = threeSum(-4,-1,-1,0,1,2,2);
        for (var threeSum : threeSums) {
            System.out.println(threeSum);
        }
    }

    public static List<List<Integer>> threeSum(int... nums) {
        Arrays.sort(nums);
        List<List<Integer>> sumList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {
                    sumList.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (k > j && nums[k] == nums[k+1]) k--;
                }
            }
            while (i + 2 < nums.length && nums[i+1] == nums[i]) i++;
        }

        return sumList;
    }

    public static List<List<Integer>> threeSum2(int... nums) {
        Arrays.sort(nums);
        List<List<Integer>> threeSums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 2; j < nums.length; j++) {
                int thirdIndex = binarySearch(nums, - (nums[i] + nums[j]), i + 1, j - 1);
                if (thirdIndex != -1) {
                    threeSums.add(List.of(nums[i], nums[thirdIndex], nums[j]));
                    while (j + 1 < nums.length && nums[j+1] == nums[j]) j++;
                }
            }
            while (i + 1 < nums.length && nums[i+1] == nums[i]) i++;
        }
        return threeSums;
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        while (start < end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            else if (nums[middle] < target) {
                start = middle + 1;
            }
            else {
                end = middle;
            }
        }
        return start < nums.length && nums[start] == target ? start : -1;
    }
}
