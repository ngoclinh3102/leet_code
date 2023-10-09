package logixtek.moitech.leetcode.practice;

public class L069 {

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2_147_395_600));
        System.out.println(mySqrt(2_147_483_647));
    }

    public static int mySqrt(int x) {
        int left = 0;
        int right = x/2 + 1;
        while (left < right) {
            int middle = (left + right + 1) / 2;
            if ((long) middle * middle == x) return middle;
            else if ((long) middle * middle < x) left = middle;
            else right = middle - 1;
        }
        return left;
    }
}
