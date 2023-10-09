package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L137 {

    public static void main(String[] args) {
//        System.out.println(singleNumber(2,2,3,2));
        System.out.println(singleNumber(0,1,0,1,0,1,99));
    }

    public static int singleNumber(int... nums) {
        int ones = 0;
        int twos = 0;
        System.out.println(Integer.toBinaryString(ones)); System.out.println(Integer.toBinaryString(twos)); System.out.println();

        for (int num : nums) {
            ones ^= (num & ~twos);
            twos ^= (num & ~ones);
            System.out.println(Integer.toBinaryString(ones)); System.out.println(Integer.toBinaryString(twos)); System.out.println();
        }

        System.out.println(Arrays.toString(nums));

        return ones;
    }
}
