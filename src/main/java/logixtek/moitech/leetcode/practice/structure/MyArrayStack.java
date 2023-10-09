package logixtek.moitech.leetcode.practice.structure;

public class MyArrayStack {

    private static final int MAX_LENGTH = 100;
    private final int[] STACK;
    private int len;

    public MyArrayStack() {
        this.STACK = new int[MAX_LENGTH];
        this.len = 0;
    }

    public void push(int x) {
        STACK[len] = x;
        len++;
    }

    public int pop() {
        len--;
        return STACK[len];
    }

    public int top() {
        return STACK[len - 1];
    }

    public boolean empty() {
        return len == 0;
    }
}
