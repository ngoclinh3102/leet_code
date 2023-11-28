package logixtek.moitech.leetcode.practice;

public class L2147 {
    public static void main(String[] args) {

    }

    public static int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;

        int i = 0;
        while (i < corridor.length() && corridor.charAt(i) == 'P') i++;

        if (i == corridor.length()) return 0; // there's no seat

        long count = 1;
        while (i < corridor.length()) {
            int seat = 0;
            while (i < corridor.length() && seat < 2) {
                if (corridor.charAt(i) == 'S') {
                    seat++;
                }
                i++;
            }

            if (seat == 1) return 0; // the number of seats is odd

            int plant = 0;
            while (i < corridor.length() && corridor.charAt(i) == 'P') {
                plant++;
                i++;
            }

            if (i < corridor.length()) {
                count = (count * (plant + 1)) % MOD;
            }
        }

        return (int) count;
    }
}
