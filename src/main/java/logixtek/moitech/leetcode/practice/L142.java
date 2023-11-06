package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.ListNode;

public class L142 {

    public static void main(String[] args) {
        ListNode list;
        list = ListNode.of(1);
        list.next = ListNode.of(2);
        list.next.next = ListNode.of(3);
        list.next.next.next = ListNode.of(4);
        list.next.next.next.next = ListNode.of(5);
        list.next.next.next.next.next = ListNode.of(6);

        System.out.println(detectCycle(list));
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        var slow = head;
        var fast = head;

        do {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}
