package logixtek.moitech.leetcode.practice.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static void main(String[] args) {
        System.out.println(primeFactors(1458));
    }

    public static List<Integer> primeFactors(int n) {
        List<Integer> primeFactors = new ArrayList<>();

        while (n % 2 == 0) {
            primeFactors.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }

        if (n > 2) {
            primeFactors.add(n);
        }

        return primeFactors;
    }

    public static void print2DArray(char[][] array2D) {
        for (char[] subArray : array2D) {
            System.out.println(Arrays.toString(subArray));
        }
    }
}
