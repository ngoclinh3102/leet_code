package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.Node;

public class L117 {

    public static void main(String[] args) {
        Node root = Node.of(1);
        root.left = Node.of(2);
        root.right = Node.of(3);
        root.left.left = Node.of(4);
        root.left.right = Node.of(5);
        root.right.right = Node.of(7);
        connect(root);
        System.out.println(root.toBSTString());
    }

    public static Node connect(Node root) {
        Node leftDeep = root;
        Node father;
        Node nextFather;
        while (leftDeep != null) {
            father = leftDeep;
            while (father != null) {
                nextFather = father.next;
                while (nextFather != null && nextFather.left == null && nextFather.right == null) {
                    nextFather = nextFather.next;
                }
                if (father.left != null) {
                    if (father.right != null) {
                        father.left.next = father.right;
                        if (nextFather != null) {
                            if (nextFather.left != null) {
                                father.right.next = nextFather.left;
                            }
                            else {
                                father.right.next = nextFather.right;
                            }
                        }
                    }
                    else {
                        if (nextFather != null) {
                            if (nextFather.left != null) {
                                father.left.next = nextFather.left;
                            }
                            else {
                                father.left.next = nextFather.right;
                            }
                        }
                    }
                }
                else {
                    if (father.right != null) {
                        if (nextFather != null) {
                            if (nextFather.left != null) {
                                father.right.next = nextFather.left;
                            }
                            else {
                                father.right.next = nextFather.right;
                            }
                        }
                    }
                }
                father = nextFather;
            }
            while (leftDeep != null && leftDeep.left == null && leftDeep.right == null) {
                leftDeep = leftDeep.next;
            }
            if (leftDeep != null) {
                if (leftDeep.left != null) {
                    leftDeep = leftDeep.left;
                }
                else {
                    leftDeep = leftDeep.right;
                }
            }
        }
        return root;
    }
}
