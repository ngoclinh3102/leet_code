package logixtek.moitech.leetcode.practice.structure;

public class BinaryIndexedTree {
    private final int[] bit;

    public BinaryIndexedTree(int size) {
        this.bit = new int[size + 1];
    }

    public void update(int index, int value) {
        while (index < bit.length) {
            bit[index] += value;
            index += index & -index;
        }
    }

    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }
        return sum;
    }
}
