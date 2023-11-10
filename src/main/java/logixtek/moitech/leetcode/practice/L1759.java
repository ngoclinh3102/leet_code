package logixtek.moitech.leetcode.practice;

public class L1759 {
    public static void main(String[] args) {

    }

    public static int countHomogenous(String s) {
        final int MOD = 1_000_000_007;
        char[] sarray = s.toCharArray();

        long count = 0;
        for (int i = 0; i < sarray.length; ) {
            int j = i + 1;
            while (j < sarray.length && sarray[j] == sarray[i]) j++;

            count += (long) (j - i) * (j - i + 1) / 2;
            count %= MOD;

            i = j;
        }

        return (int) count;
    }
}
