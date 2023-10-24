package logixtek.moitech.leetcode.practice;

public class L342 {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(1_162_261_466));
    }

    public static boolean isPowerOfFour(int n) {
        int m = n - 1;
        return (m & n) == 0 && m % 3 == 0;
    }
}
