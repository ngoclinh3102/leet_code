package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.TreeNode;

public class L543 {

    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        LRN(root);
        return diameter;

    }

    private int LRN(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftLen = LRN(node.left);
        int rightLen = LRN(node.right);

        diameter = Math.max(diameter, leftLen + rightLen);

        return Math.max(leftLen, rightLen) + 1;
    }
}
