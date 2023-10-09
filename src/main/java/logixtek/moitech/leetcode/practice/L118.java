package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class L118 {

    public static void main(String[] args) {
        var pascalTriangle = generate(33);
        for (var row : pascalTriangle) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int c;
        for (int row = 1; row <= numRows; row++) {
            c = 1;
            List<Integer> subList = new ArrayList<>();
            for (int i = 1; i <= row; i++) {
                subList.add(c);
                c = c * (row - i) / i;
            }
            list.add(subList);
        }
        return list;
    }
}
