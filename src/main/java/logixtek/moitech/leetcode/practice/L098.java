package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.TreeNode;

public class L098 {
    public static void main(String[] args) {
        TreeNode root;
        root = TreeNode.of(22);
        root.left = TreeNode.of(12);
        root.right = TreeNode.of(30);
        root.left.left = TreeNode.of(8);
        root.left.right = TreeNode.of(20);
        root.right.left = TreeNode.of(25);
        root.right.right = TreeNode.of(40);

        System.out.println(isValidBST(root));
    }

    private static Integer prevNode;

    public static boolean isValidBST(TreeNode root) {
        prevNode = null;
        return validate(root);
    }

    private static boolean validate(TreeNode node) {
        if (node == null) return true;

        if (!validate(node.left)) return false;

        if (prevNode != null && prevNode >= node.val) return false;
        prevNode = node.val;

        return validate(node.right);
    }
}
