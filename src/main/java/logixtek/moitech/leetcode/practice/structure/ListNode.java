package logixtek.moitech.leetcode.practice.structure;

public class ListNode {
    public int val;
    public ListNode next;

    public static ListNode of(int val) {
        return new ListNode(val);
    }

    public static ListNode of(int val, ListNode next) {
        return new ListNode(val, next);
    }

    public ListNode() {}

    public ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        ListNode node = new ListNode(val, next);
        while (node != null) {
            builder.append(node.val).append(",");
            node = node.next;
        }
        return builder.deleteCharAt(builder.length() - 1).append("]").toString();
    }
}
