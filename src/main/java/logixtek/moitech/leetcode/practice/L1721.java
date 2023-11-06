package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.ListNode;

public class L1721 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        System.out.println(swapNodes(head, 1));
//        System.out.println(swapNodes(head, 2));
        System.out.println(swapNodes(head, 3));
//        System.out.println(swapNodes(head, 4));
//        System.out.println(swapNodes(head, 5));
//        System.out.println(swapNodes(head, 6));
    }

    public static ListNode swapNodes2(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevFirstNode = dummy;
        ListNode prevSecondNode = dummy;
        ListNode pointer = dummy;

        for (int i = 0; i + 1 < k; i++) {
            pointer = pointer.next;
            prevFirstNode = prevFirstNode.next;
        }

        pointer = pointer.next;
        while (pointer.next != null) {
            pointer = pointer.next;
            prevSecondNode = prevSecondNode.next;
        }

        ListNode firstNode = prevFirstNode.next;
        ListNode secondNode = prevSecondNode.next;

        prevFirstNode.next = prevFirstNode.next.next;
        firstNode.next = prevSecondNode.next;
        prevSecondNode.next = firstNode;

        prevSecondNode.next = prevSecondNode.next.next;
        secondNode.next = prevFirstNode.next;
        prevFirstNode.next = secondNode;

        return dummy.next;
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode pointer = head;
        ListNode firstNode = head;
        ListNode secondNode = head;

        for (int i = 0; i + 1 < k; i++) {
            pointer = pointer.next;
            firstNode = firstNode.next;
        }
        while (pointer.next != null) {
            pointer = pointer.next;
            secondNode = secondNode.next;
        }

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

        return head;
    }
}
