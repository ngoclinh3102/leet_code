package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.ListNode;

import java.util.ArrayList;
import java.util.List;

public class L086 {

    public static void main(String[] args) {
        System.out.println(partition(new ListNode(1, new ListNode(4, new ListNode(3 , new ListNode(2 , new ListNode(5, new ListNode(2, null)))))), 3).toString());
    }

    public static ListNode partition(ListNode head, int x) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while (head != null) {
            if (head.val < x) list1.add(head.val);
            else list2.add(head.val);
            head = head.next;
        }

        for (int i = list2.size() - 1; i >= 0; i--) head = new ListNode(list2.get(i), head);
        for (int i = list1.size() - 1; i >= 0; i--) head = new ListNode(list1.get(i), head);

        return head;
    }
}
