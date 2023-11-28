package logixtek.moitech.leetcode.practice;

import org.springframework.stereotype.Component;

import java.util.*;

@Component("HARD")
public class L632 {
    public static void main(String[] args) {
        List<List<Integer>> nums = List.of(
                List.of(4, 10, 15, 24, 26),
                List.of(0, 9, 12, 20),
                List.of(5, 18, 22, 30)
        );
        System.out.println(Arrays.toString(smallestRange(nums)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();

        PriorityQueue<Number> bench = new PriorityQueue<>(Comparator.comparingInt(i -> i.value));
        for (int i = 0; i < k; i++) {
            bench.offer(Number.of(i, 0, nums.get(i).get(0)));
        }

        int numOfList = 0;
        int[] frequency = new int[k];
        LinkedList<Number> window = new LinkedList<>();

        int[] range = {-100_000, 100_000};

        while (bench.size() > 0) {
            Number high = bench.poll();

            window.offer(high);

            frequency[high.list]++;

            if (frequency[high.list] == 1) numOfList++;

            while (numOfList == k && window.size() > 0) {
                Number low = window.poll();

                frequency[low.list]--;

                if (frequency[low.list] == 0) {
                    numOfList--;

                    if (high.value - low.value < range[1] - range[0]) {
                        range[1] = high.value;
                        range[0] = low.value;
                    }
                }
            }

            int nextIndex = high.index + 1;
            if (nextIndex < nums.get(high.list).size()) {
                bench.offer(Number.of(high.list, nextIndex, nums.get(high.list).get(nextIndex)));
            }
        }

        return range;
    }

    private static class Number {
        int list;
        int index;
        int value;

        Number(int list, int index, int value) {
            this.list = list;
            this.index = index;
            this.value = value;
        }

        static Number of(int list, int index, int value) {
            return new Number(list, index, value);
        }
    }
}
