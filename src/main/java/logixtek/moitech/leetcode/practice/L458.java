package logixtek.moitech.leetcode.practice;

import org.springframework.stereotype.Component;

@Component("HARD")
public class L458 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(125 * i);
        }
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int numOfTries = minutesToTest / minutesToDie;
        int pigs = 1;
        while (Math.pow(numOfTries + 1, pigs) < buckets) pigs++;
        return pigs;
    }
}
