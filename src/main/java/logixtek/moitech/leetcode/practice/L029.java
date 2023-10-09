package logixtek.moitech.leetcode.practice;

public class L029 {
    public static void main(String[] args) {
        // TODO
    }

    public int divide(int dividend, int divisor) {
        int quotient = 0;
        int remainder = 0;

        for (int i = 3; i >= 0; i--) {
            remainder <<=  1;
            remainder |= (dividend >> i) & 1;
            if (remainder >= divisor) {
                remainder -= divisor;
                quotient |= (1 << i);
            }
        }

        return quotient;
    }
}
