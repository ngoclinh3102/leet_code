package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.ListNode;

public class L061 {
    public static void main(String[] args) {

        ListNode node = new L061().rotateRight(new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,new ListNode(7,new ListNode(8,new ListNode(9,new ListNode(10)))))))))),
                                                 0);
        System.out.println(node != null ? node.toString(): null);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int len = 1;
        ListNode pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
            len++;
        }
        pointer.next = head;

        k = len - (k % len);
        while (k-->0) pointer = pointer.next;

        head = pointer.next;
        pointer.next = null;

        return head;
    }
}
