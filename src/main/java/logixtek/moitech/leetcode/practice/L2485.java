package logixtek.moitech.leetcode.practice;

public class L2485 {
    public static void main(String[] args) {

    }

    public int pivotInteger(int n) {
        double pivot = Math.sqrt((n * (n + 1.0)) / 2);
        return (pivot == (int) pivot) ? (int) pivot : -1;
    }
}
