package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L1011 {
    public static void main(String[] args) {

    }

    public static int shipWithinDays(int[] weights, int days) {
        int high = 0;
        int low = weights[0];
        for (int w : weights) {
            high += w;
            low = Math.max(low, w);
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            int totalDay = 1;
            int loadPerDay = 0;
            for (int w : weights) {
                loadPerDay += w;
                if (loadPerDay > mid) {
                    totalDay++;
                    loadPerDay = w;
                }
            }

            if (totalDay <= days) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }
}
