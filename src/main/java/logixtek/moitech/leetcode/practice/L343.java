package logixtek.moitech.leetcode.practice;

public class L343 {

    public static void main(String[] args) {
        System.out.println(integerBreak(57));
    }

    public static int integerBreak(int n) {
        if (n < 4) return n - 1;
        int ans = 1;
        while (n > 4) {
            n -= 3;
            ans *= 3;
        }
        return ans * n;
    }
}
