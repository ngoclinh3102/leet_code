package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.Node;

public class L116 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(connect(root).toBSTString());
    }

    public static Node connect(Node root) {
        Node vp = root;
        while (vp != null) {
            Node hp = vp;
            while (hp != null && hp.left != null) {
                hp.left.next = hp.right;
                if (hp.next != null) {
                    hp.right.next = hp.next.left;
                }
                hp = hp.next;
            }
            vp = vp.left;
        }
        return root;
    }
}
