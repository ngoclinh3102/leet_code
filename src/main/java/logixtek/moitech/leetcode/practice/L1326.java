package logixtek.moitech.leetcode.practice;

public class L1326 {

    public static void main(String[] args) {
        System.out.println(minTaps(5, 3, 4, 1, 1, 0, 0));
    }

    public static int minTaps(int n, int... ranges) {
        int[] arr = new int[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }

        int count = 0;
        int end = 0;
        int far_can_reach = 0;
        for (int i = 0; i < ranges.length; i++) {
            if (i > end) {
                if (end >= far_can_reach) return -1;
                end = far_can_reach;
                count++;
            }
            far_can_reach = Math.max(far_can_reach, arr[i]);
        }

        return count + (end + 1 < ranges.length ? 1 : 0);
    }
}