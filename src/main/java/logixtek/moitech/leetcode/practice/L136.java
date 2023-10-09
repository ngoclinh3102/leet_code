package logixtek.moitech.leetcode.practice;

public class L136 {

    public static void main(String[] args) {
        System.out.println(singleNumber(4, 1, 2, 2, 2));
    }

    public static int singleNumber(int... nums) {
        int xorSum = 0;
        for (int num : nums) xorSum ^= num;
        return xorSum;
    }
}
