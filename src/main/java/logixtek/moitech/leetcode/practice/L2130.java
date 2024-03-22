package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.ListNode;

public class L2130 {

    public static void main(String[] args) {

    }

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = slow.next;
        fast = null;
        while (slow != null) {
            ListNode temp = slow;
            slow = slow.next;
            temp.next = fast;
            fast = temp;
        }

        slow = head;
        int sum = 0;
        while (fast != null) {
            sum = Math.max(sum, fast.val + slow.val);
            fast = fast.next;
            slow = slow.next;
        }

        return sum;
    }
}
