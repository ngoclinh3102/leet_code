package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L1561 {
    public static void main(String[] args) {
        System.out.println(maxCoins(1,2,2,4,4,5,3,14,21,41,24,41,41,51,5));
    }

    public static int maxCoins(int... piles) {
        Arrays.sort(piles);
        int mine = 0;
        int i = piles.length / 3;
        while (i < piles.length) {
            mine += piles[i];
            i += 2;
        }
        return mine;
    }
}
