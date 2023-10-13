package logixtek.moitech.leetcode.practice;

public class L070 {

    public static int climbStairs(int n) {
        if (n < 3) return n;

        int answer = 2;
        int prev = 1;
        for (int i = 3; i <= n; i++) {
            answer += prev;
            prev = answer - prev;
        }

        return answer;
    }
}
