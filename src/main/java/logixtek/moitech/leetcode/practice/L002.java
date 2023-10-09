package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.ListNode;

import java.util.ArrayList;

public class L002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var list = new ArrayList<Integer>();
        int sum = 0;
        while (l1 != null || l2 != null || sum > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            list.add(0,sum % 10);
            sum /= 10;
        }

        ListNode node = null;
        for (int i : list) {
            node = new ListNode(i, node);
        }
        return node;
    }

    public static void main(String[] args) {
        var node1 = new ListNode(3,
                                 new ListNode(9,
                                              new ListNode(9,
                                                           new ListNode(9,
                                                                        new ListNode(9,
                                                                                     new ListNode(9,
                                                                                                  new ListNode(9,
                                                                                                               new ListNode(9,
                                                                                                                            new ListNode(9 ,
                                                                                                                                         new ListNode(9, null))))))))));
        var node2= new ListNode(5, null);
        var node3 = new ListNode(7, null);

        L445.printNode(addTwoNumbers(node2, node2));
    }
}
