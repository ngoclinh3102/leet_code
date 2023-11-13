package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;

public class L2659 {
    public static void main(String[] args) {
        // TODO ~ binary index tree
    }

    public static long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, Comparator.comparingInt(i -> nums[i]));

        BinaryIndexedTree tree = new BinaryIndexedTree(n);

        long count = 0;

        return count;
    }

    private static class BinaryIndexedTree {
        final int[] bit;

        BinaryIndexedTree(int size) {
            this.bit = new int[size + 1];
        }

        void update(int index) {
            while (index < bit.length) {
                bit[index]++;
                index += index & -index;
            }
        }

        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}
