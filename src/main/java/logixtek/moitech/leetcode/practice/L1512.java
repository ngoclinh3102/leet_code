package logixtek.moitech.leetcode.practice;

public class L1512 {

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(1,2,3,1,1,3));
    }

    public static int numIdenticalPairs(int... nums) {
        int pairs = 0;
        int[] counts = new int[101];
        for (int n : nums) {
            pairs += counts[n];
            counts[n]++;
        }
        return pairs;
    }
}
