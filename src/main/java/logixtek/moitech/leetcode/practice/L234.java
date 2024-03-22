package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.ListNode;

public class L234 {
    public boolean isPalindrome(ListNode head) {
        ListNode rev = null;

        ListNode temp = head;
        while (temp != null) {
            rev = new ListNode(temp.val, rev);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (temp.val != rev.val) {
                return false;
            }
            temp = temp.next;
            rev = rev.next;
        }

        return true;
    }
}
