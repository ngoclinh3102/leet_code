package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.LinkedList;

public class L1673 {
    public static void main(String[] args) {
        int[] nums = {12, 38, 19, 5, 27, 43, 7, 32, 23, 15, 41, 8, 14, 30, 4, 29, 34, 6, 9, 46};
        System.out.println(Arrays.toString(mostCompetitive(nums, 5)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        int[] answer = new int[k];
        LinkedList<Integer> monostack = new LinkedList<>();

        for (int i = 0, j = 0; j < k; j++) {
            if (i < nums.length) {
                do {
                    while (monostack.size() > 0 && monostack.getLast() < nums[i]) {
                        monostack.removeLast();
                    }
                    monostack.addLast(nums[i++]);
                } while (i <= nums.length - k);
            }

            answer[j] = monostack.removeFirst();
        }

        return answer;
    }
}
