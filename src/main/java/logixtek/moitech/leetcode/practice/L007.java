package logixtek.moitech.leetcode.practice;

public class L007 {

    public static void main(String[] args) {
        int ans = reverse(-2147457412);
        System.out.println(ans);
    }

    public static int reverse(int x) {
        int reverse = 0;

        int sign = x > 0 ? 1 : -1;
        x *= sign;

        while (x > 0) {
            if (reverse > (Integer.MAX_VALUE - x % 10) / 10) return 0;
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return sign * reverse;
    }
}