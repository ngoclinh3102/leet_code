package logixtek.moitech.leetcode.practice;

import org.springframework.stereotype.Component;

import java.util.*;

@Component("HARD")
public class L632 {
    public static void main(String[] args) {
        List<List<Integer>> nums2 = List.of(
                List.of(4, 10, 15, 24, 26),
                List.of(0, 9, 12, 20),
                List.of(5, 18, 22, 30)
        );
        List<List<Integer>> nums = List.of(List.of(1));
        System.out.println(Arrays.toString(smallestRange(nums)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();

        PriorityQueue<Number> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i.value));
        for (int i = 0; i < k; i++) {
            queue.offer(Number.of(i, 0, nums.get(i).get(0)));
        }

        int memberInWindow = 0;
        int[] frequencyInWindow = new int[k];
        LinkedList<Number> window = new LinkedList<>();

        int[] range = {-100_000, 100_000};

        while (queue.size() > 0) {
            Number current = queue.poll();

            window.offer(current);
            frequencyInWindow[current.list]++;

            if (frequencyInWindow[current.list] == 1) {
                memberInWindow++;
            }

            if (memberInWindow == k) {
                while (window.size() > 0) {
                    Number low = window.pollFirst();
                    frequencyInWindow[low.list]--;

                    if (frequencyInWindow[low.list] == 0) {
                        int high = window.size() > 0 ? window.peekLast().value : low.value;
                        if (high - low.value < range[1] - range[0]) {
                            range[1] = high;
                            range[0] = low.value;
                        }

                        memberInWindow--;
                        break;
                    }
                }
            }

            int nextIndex = current.index + 1;
            if (nextIndex < nums.get(current.list).size()) {
                queue.offer(Number.of(current.list, nextIndex, nums.get(current.list).get(nextIndex)));
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
