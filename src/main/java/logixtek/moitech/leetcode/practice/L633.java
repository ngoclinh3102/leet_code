package logixtek.moitech.leetcode.practice;

public class L633 {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2)); // true
        System.out.println(judgeSquareSum(3)); // false
        System.out.println(judgeSquareSum(5)); // true
        System.out.println(judgeSquareSum(8)); // true
        System.out.println(judgeSquareSum(10)); // true
        System.out.println(judgeSquareSum(2147483600)); // true
    }

    public static boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);
        while (a <= b) {
            long cTemp = a * a + b * b;
            if (cTemp == c) return true;
            else if (cTemp > c) b--;
            else a++;
        }
        return false;
    }
}
