package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.ListNode;

public class L092 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,new ListNode(7,new ListNode(8,new ListNode(9,new ListNode(10))))))))));
        ListNode node2 = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4))));

        System.out.println(reverseBetween3(node, 2, 10));
        System.out.println(reverseBetween3(node2, 1, 4));
    }

    public static ListNode reverseBetween3(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        for (int i = 0; i + 1 < left; i++) prev = prev.next;

        ListNode curr = prev.next;
        for (int i = 0; i + left < right; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }


    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        int index = 0;
        ListNode leftNode = head;
        while (index + 1 < left) {
            leftNode = leftNode.next;
            index++;
        }
        while (left < right) {
            ListNode pointer = leftNode;
            while (index + 1 < right) {
                pointer = pointer.next;
                index++;
            }
            int temp = pointer.val;
            pointer.val = leftNode.val;
            leftNode.val = temp;

            index = left++;
            right--;
            leftNode = leftNode.next;
        }
        return head;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int length = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            length++;
        }
        pointer = head;
        ListNode[] nodes = new ListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = pointer;
            pointer = pointer.next;
        }
        int temp;
        while (left < right) {
            temp = nodes[right-1].val;
            nodes[right-1].val = nodes[left-1].val;
            nodes[left-1].val = temp;
            left++;
            right--;
        }
        return nodes[0];
    }
}
