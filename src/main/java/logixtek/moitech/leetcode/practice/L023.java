package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L023 {

    public static void main(String[] args) {
        ListNode[] lists = {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6)),
                null,
                null,
        };
        System.out.println(mergeKLists(lists));
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode pointer = dummyHead;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            pointer.next = node;
            pointer = pointer.next;

            if (node.next != null) pq.add(node.next);
        }

        return dummyHead.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return lists.length > 0
               ? mergeSort(lists, 0, lists.length - 1)
               : null;
    }

    private static ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start + 1 == end) return merge(lists[start], lists[end]);

        int mid = (start + end) / 2;
        return merge(
                mergeSort(lists, start, mid),
                mergeSort(lists, mid + 1, end)
        );
    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pointer = dummyHead;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
               pointer.next = node1;
               node1 = node1.next;
            }
            else {
                pointer.next = node2;
                node2 = node2.next;
            }
            pointer = pointer.next;
        }
        pointer.next = (node1 != null) ? node1 : node2;

        return dummyHead.next;
    }
}
