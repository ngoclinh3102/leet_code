package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 65_536; i++) {
            list.add(i);
        }

        long start, end;
        start = System.currentTimeMillis();
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        end = System.currentTimeMillis();
        System.out.println("For i: Sum = " + sum + "; Runtime: " + (end - start) + ".");

        //
        start = System.currentTimeMillis();
        int sum2 = list.stream().reduce(0, Integer::sum);
        end = System.currentTimeMillis();
        System.out.println("Stream: Sum = " + sum2 + "; Runtime: " + (end - start) + ".");
    }
}
