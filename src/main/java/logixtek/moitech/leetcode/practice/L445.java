package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L445 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var stack1 = new Stack<Integer>();
        var stack2 = new Stack<Integer>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode node = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || sum > 0) {
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            node = new ListNode(sum % 10, node);
            sum /= 10;
        }

        return node;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        var num1 = new ArrayList<Integer>();
        var num2 = new ArrayList<Integer>();

        num1.add(l1.val);
        while (l1.next != null) {
            l1 = l1.next;
            num1.add(l1.val);
        }

        num2.add(l2.val);
        while (l2.next != null) {
            l2 = l2.next;
            num2.add(l2.val);
        }

        return num1.size() > num2.size() ? plusListNumber(num1, num2) : plusListNumber(num2, num1);
    }

    public static ListNode plusListNumber(List<Integer> list1, List<Integer> list2) {
        ListNode node = null;
        var i = list1.size() - 1;
        var j = list2.size() - 1;
        var r = 0;
        while (i >= 0) {
            var sum = list1.get(i--) + (j >= 0 ? list2.get(j--) : 0) + r;
            node = new ListNode(sum % 10, node);
            r = sum / 10;
        }
        return r == 0 ? node : new ListNode(1, node);
    }

    public static void printNode(ListNode node) {
        if (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            while (node.next != null) {
                node = node.next;
                System.out.print(node.val + (node.next != null ? " -> " : ""));
            }
        }
        System.out.println();
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
        var node2 = new ListNode(7, null);
        var node3 = new ListNode(7, null);
        printNode(addTwoNumbers(node3, node2));
//        System.out.println(plusListNumber(Arrays.asList(5),Arrays.asList(5)));
    }
}

