package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().orElse(1);

        while (left < right) {
            int speed = (right + left) / 2;

            int time = 0;
            for (int pile : piles) {
                time += Math.ceil((double) pile / speed);
            }

            if (time > h) {
                left = speed + 1;
            }
            else {
                right = speed;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[] {3,6,7,11}, 8)); // 4
//        System.out.println(minEatingSpeed(new int[] {30,11,23,4,20}, 5)); // 30
//        System.out.println(minEatingSpeed(new int[] {30,11,23,4,20}, 6)); // 23
    }
}
