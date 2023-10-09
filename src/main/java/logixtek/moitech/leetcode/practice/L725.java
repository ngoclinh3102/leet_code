package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.ListNode;


public class L725 {

    public static void main(String[] args) {
        L725 l725 = new L725();

        ListNode[] nodes = l725.splitListToParts(new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,new ListNode(7,new ListNode(8,new ListNode(9,new ListNode(10)))))))))),
                                                 8);
        for (ListNode node : nodes) System.out.println(node != null ? node.toString(): null);
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] nodes = new ListNode[k];

        if (head == null) return nodes;

        int length = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            length++;
        }

        int minSize = length / k;
        int extraSize = length - minSize * k;

        for (int i = 0; i < k; i++) {
            nodes[i] = head;
            pointer = head;

            int iSize = minSize + (extraSize-- > 0 ? 1 : 0);
            while (pointer != null && iSize-- > 1) pointer = pointer.next;

            if (pointer.next == null) break;

            head = pointer.next;
            pointer.next = null;
        }

        return nodes;
    }
}
