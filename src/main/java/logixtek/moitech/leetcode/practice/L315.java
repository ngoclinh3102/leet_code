package logixtek.moitech.leetcode.practice;

import java.util.LinkedList;
import java.util.List;

public class L315 {
    public static void main(String[] args) {
        // TODO - merge sort
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            list.add(count);
        }

        return list;
    }
}
