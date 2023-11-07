package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L1921 {
    public static void main(String[] args) {

    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;

        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            times[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(times);

        int count = 0;
        while (count < n && count < times[count]) count++;

        return count;
    }

}
