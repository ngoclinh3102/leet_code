package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.ListNode;

public class L025 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(reverseKGroup(head, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode prevPointer = dummy;
        ListNode pointer = prevPointer.next;
        ListNode temp;

        int size = 0;
        while (pointer != null) {
            pointer = pointer.next;
            size++;
        }

        pointer = prevPointer.next;
        for (int i = 0; i + k <= size; i += k) {
            for (int j = 1; j < k; j++) {
                temp = pointer.next;
                pointer.next = pointer.next.next;
                temp.next = prevPointer.next;
                prevPointer.next = temp;
            }
            prevPointer = pointer;
            pointer = pointer.next;
        }

        return dummy.next;
    }
}
