package logixtek.moitech.leetcode.practice;

public class L1854 {

    public static int maximumPopulation(int[][] logs) {
        int[] populations = new int[101];
        
        for (var log : logs) {
            populations[log[0] - 1950]++;
            populations[log[1] - 1950]--;
        }

        int current = populations[0];
        int maxPopulation = current;
        int maxYear = 0;
        for (int i = 1; i < populations.length; i++) {
            current += populations[i];
            if (maxPopulation < current) {
                maxPopulation = current;
                maxYear = i;
            }
        }

        return maxYear;
    }
}
