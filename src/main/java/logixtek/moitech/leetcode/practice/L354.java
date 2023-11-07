package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L354 {
    public static void main(String[] args) {
        // TODO ~ Russian Dolls
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return 0;
    }
}
