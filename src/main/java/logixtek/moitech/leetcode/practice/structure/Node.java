package logixtek.moitech.leetcode.practice.structure;

public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;

    public Node(int val) { this.val = val; }

    public static Node of(int val) {
        return new Node(val);
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public String toBSTString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node pointer = new Node(val, left, right, next);
        while (pointer != null) {
            Node p = pointer;
            while (p != null) {
                builder.append(p.val).append(",");
                p = p.next;
            }
            builder.append("#").append(",");
            pointer = pointer.left;
        }
        builder.deleteCharAt(builder.length() - 1).append("]");
        return builder.toString();
    }
}
