package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.ListNode;

public class L143 {

    public static void main(String[] args) {
        ListNode head8 = ListNode.of(1, ListNode.of(2, ListNode.of(3, ListNode.of(4, ListNode.of(5, ListNode.of(6, ListNode.of(7, ListNode.of(8))))))));
        ListNode head7 = ListNode.of(1, ListNode.of(2, ListNode.of(3, ListNode.of(4, ListNode.of(5, ListNode.of(6, ListNode.of(7)))))));
        reorderList(head8);
        reorderList(head7);
    }
    public static void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) return;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
        }
        ListNode temp;
        while (p1.next != null) {
            temp = p1.next;
            p1.next = temp.next;
            temp.next = head.next;
            head.next = temp;
        }
        p1 = p2 = head;
        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
        }
        p2 = head.next;
        while (p2.next != null && p2.next.next != null) {
            temp = p1.next;
            p1.next = temp.next;
            temp.next = p2.next;
            p2.next = temp;
            p2 = p2.next.next;
        }
        System.out.println(head);
    }
}
