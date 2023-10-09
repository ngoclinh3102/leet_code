package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class L119 {
    public static void main(String[] args) {
        System.out.println(getRow(12));
    }

    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> list = new ArrayList<>();
        long c = 1;
        for (int i=1; i<=rowIndex; i++) {
            list.add((int) c);
            c = c * (rowIndex - i) / (i);
        }
        return list;
    }
}
