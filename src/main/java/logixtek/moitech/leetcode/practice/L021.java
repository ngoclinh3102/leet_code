package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.ListNode;

public class L021 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));

        System.out.println(mergeTwoLists(node1, node2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pointer = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            }
            else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }
        pointer.next = (list1 != null) ? list1 : list2;

        return dummyHead.next;
    }
}
