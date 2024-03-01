package logixtek.moitech.leetcode.practice;

public class L997 {

    public int findJudge(int n, int[][] trust) {
        if (trust.length >= n - 1) {

            int[] scores = new int[n+1];

            for (var relation : trust) {
                scores[relation[0]] = -1;
                scores[relation[1]]++;
            }

            for (int i = 1; i <= n; i++) {
                if (scores[i] == n - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}
