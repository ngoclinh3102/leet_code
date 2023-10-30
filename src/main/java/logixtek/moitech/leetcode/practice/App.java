package logixtek.moitech.leetcode.practice;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        Runnable runnable = () -> { double i = random.nextDouble(1000) % random.nextDouble(1000);  };
        int numThread = 100_000;

        long start, end;

        start = System.currentTimeMillis();
        for (int i = 0; i < numThread; i++) {
            new Thread(runnable).start();
        }
        end = System.currentTimeMillis();
        System.out.println("Runtime old thread: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < numThread; i++) {
            Thread.startVirtualThread(runnable);
        }
        end = System.currentTimeMillis();
        System.out.println("Runtime virtual thread: " + (end - start));
    }
}
