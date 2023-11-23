package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1424 {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(List.of(0, 2, 5, 8));
        nums.add(List.of(1, 4, 7, 9));
        nums.add(List.of(3, 6));

        System.out.println(Arrays.toString(findDiagonalOrder(nums)));
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                coordinates.add(Coordinate.of(i, j));
            }
        }

        coordinates.sort((c1, c2) -> c1.weight != c2.weight ? c1.weight - c2.weight : c1.j - c2.j);

        int index = 0;
        int[] diagonal = new int[coordinates.size()];
        for (var c : coordinates) {
            diagonal[index++] = nums.get(c.i).get(c.j);
        }

        return diagonal;
    }

    private static class Coordinate {
        int i;
        int j;
        int weight;

        Coordinate(int i, int j) {
            this.weight = (this.i = i) + (this.j = j);
        }

        static Coordinate of(int i, int j) {
            return new Coordinate(i, j);
        }
    }
}
