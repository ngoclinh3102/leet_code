package logixtek.moitech.leetcode.practice;

public class L517 {
    public static void main(String[] args) {
        System.out.println(findMinMoves(0, 0, 11, 5));
    }

    public static int findMinMoves(int... machines) {
        int sum = 0;
        for (int machine : machines) sum += machine;

        if (sum % machines.length > 0) return -1;

        int avg = sum / machines.length;

        int count = 0;
        int minMoves = 0;

        for (int machine : machines) {
            count = count + machine - avg;
            minMoves = Math.max(Math.max(minMoves, machine-avg), Math.abs(count));
        }

        return minMoves;
    }
}
