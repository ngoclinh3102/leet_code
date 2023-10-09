package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.ListNode;

public class L024 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        System.out.println(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevPointer = dummy;
        ListNode pointer = dummy.next;
        ListNode temp;

        while (pointer != null && pointer.next != null) {
            temp = pointer.next;
            pointer.next = pointer.next.next;
            temp.next = prevPointer.next;
            prevPointer.next = temp;

            prevPointer = pointer;
            pointer = pointer.next;
        }

        return dummy.next;
    }
}
