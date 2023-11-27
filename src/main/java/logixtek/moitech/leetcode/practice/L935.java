package logixtek.moitech.leetcode.practice;

public class L935 {
    public static void main(String[] args) {
        System.out.println(knightDialer(6));
    }

    private static final int MOD = 1_000_000_007;
    private static final int[][] dialer = {{4,6}, {6,8}, {7,9}, {4,8}, {0,3,9}, {}, {0,1,7}, {2,6}, {1,3}, {2,4}};

    public static int knightDialer(int n) {
        if (n == 1) return 10;

        long[] counts = new long[10];
        return dialing(n, 1, counts);
    }

    private static int dialing(int n, int numOfDigits, long[] counts) {
        if (n == numOfDigits) {
            long answer = 0;
            for (long c : counts) answer += c;
            return (int) (answer % MOD);
        }

        long[] nextCount = new long[counts.length];

        for (int i = 0; i < dialer.length; i++) {
            for (int number : dialer[i]) {
                nextCount[number] += counts[i];
            }
            nextCount[i] %= MOD;
        }

        return dialing(n, numOfDigits + 1, nextCount);
    }
}
