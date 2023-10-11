package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L2251 {
    public static void main(String[] args) {
        int[][] flowers = {{1, 6}, {3, 7}, {4, 13}, {9, 12}};
        int[] people = {2, 3, 7, 11};
        System.out.println(Arrays.toString(fullBloomFlowers(flowers, people)));

    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] starts = new int[flowers.length];
        int[] ends = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < people.length; i++) {
            int visitTime = people[i];
            int blooming = searchLastStart(starts, visitTime);
            int withered = searchFirstEnd(ends, visitTime);

            people[i] = blooming - withered;
        }

        return people;
    }

    private static int searchLastStart(int[] starts, int time) {
        int low = 0;
        int high = starts.length;

        while (low < high) {
            int mid = (low + high) >>> 1;

            if (starts[mid] <= time) low = mid + 1;
            else high = mid;
        }

        return low;
    }

    private static int searchFirstEnd(int[] ends, int time) {
        int low = 0;
        int high = ends.length;

        while (low < high) {
            int mid = (low + high) >>> 1;

            if (ends[mid] >= time) high = mid;
            else low = mid + 1;
        }

        return low;
    }
}
