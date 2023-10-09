package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.ListNode;

public class L019 {

    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevRemoval = dummy;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            prevRemoval = prevRemoval.next;
        }
        prevRemoval.next = prevRemoval.next.next;
        return dummy.next;
    }
}
