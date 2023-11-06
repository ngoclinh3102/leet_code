package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.SeatManager;

public class L1845 {
    public static void main(String[] args) {
        SeatManager manager = new SeatManager(2);

        manager.reserve();
        manager.unreserve(1);

        manager.reserve();
        manager.reserve();
        manager.unreserve(2);

        manager.reserve();
        manager.unreserve(1);

        manager.reserve();
        manager.unreserve(2);

        manager.reserve();
    }
}
