package logixtek.moitech.leetcode.practice;

public class L191 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(hammingWeight(i));
        }
    }

    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
