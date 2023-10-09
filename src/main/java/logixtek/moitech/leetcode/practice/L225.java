package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.MyStack;

public class L225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // 3
        stack.push(4);
        System.out.println(stack.pop()); // 4
        System.out.println(stack.empty()); // false
    }
}
