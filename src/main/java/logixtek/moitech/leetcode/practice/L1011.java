package logixtek.moitech.leetcode.practice;

public class L1011 {
    public static void main(String[] args) {

    }

    public static int shipWithinDays(int[] weights, int days) {
        int high = 0;
        int low = 0;

        for (int w : weights) {
            high += w;
            low = Math.max(low, w);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            int loadPerDay = 0;
            for (int w : weights) {
                loadPerDay += w;
                if (loadPerDay > mid) {
                    loadPerDay = w;
                    count++;
                }
            }

            if (count >= days) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }
}
