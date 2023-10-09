package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.ListNode;

public class L141 {

    public static void main(String[] args) {
        ListNode list;
        list = ListNode.of(1);
        list.next = ListNode.of(2);
        list.next.next = ListNode.of(3);
        list.next.next.next = ListNode.of(4);
        list.next.next.next.next = ListNode.of(5);
        list.next.next.next.next.next = ListNode.of(6);

        System.out.println(hasCycle(list));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        var slow = head;
        var fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast != null && fast.equals(slow)) return true;
        }

        return false;
    }
}
