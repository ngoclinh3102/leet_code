package logixtek.moitech.leetcode.practice.structure;

import java.util.PriorityQueue;

public class SeatManager {

    private final PriorityQueue<Integer> seats;
    private int next;

    public SeatManager(int n) {
        seats = new PriorityQueue<>(n);
        next = 1;
    }

    public int reserve() {
        return seats.size() > 0 ? seats.poll() : next++;
    }

    public void unreserve(int seatNumber) {
        seats.offer(seatNumber);
    }
}
