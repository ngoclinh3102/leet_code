package logixtek.moitech.leetcode.practice.structure;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {

    private final Queue<Integer> QUEUE;

    public MyStack() {
        this.QUEUE = new ArrayDeque<>();
    }

    public void push(int x) {
        QUEUE.offer(x);
        for (int i = 1; i < QUEUE.size(); i++) QUEUE.offer(QUEUE.poll());
    }

    public int pop() {
        return QUEUE.poll();
    }

    public int top() {
        return QUEUE.peek();
    }

    public boolean empty() {
        return QUEUE.isEmpty();
    }
}
