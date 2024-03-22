package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.ListNode;

public class L206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode res) {
        if (head == null) {
            return res;
        }
        ListNode temp = head.next;
        head.next = res;
        res = head;
        return reverse(temp, res);
    }
}
