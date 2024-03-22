package logixtek.moitech.leetcode.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class L621 {

    public static void main(String[] args) {
        // TODO
    }

    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char t : tasks) {
            counts[t - 65]++;
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(t -> -t[1]));
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                pq.offer(new int[]{i, counts[i]});
            }
        }

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -101);

        int intervals = 0;
        while (pq.size() > 0) {
            var task = pq.poll();
            while (task[1] > 0) {

            }
        }

        return 0;
    }
}
