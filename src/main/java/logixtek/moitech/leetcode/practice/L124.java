package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.TreeNode;

public class L124 {

    public static void main(String[] args) {

    }

    private static int longestPath;

    public static int maxPathSum(TreeNode root) {
        longestPath = root.val;
        maximize(root);
        return longestPath;
    }

    private static int maximize(TreeNode node) {
        if (node == null) return 0;

        int maxLeft = maximize(node.left);
        int maxRight = maximize(node.right);

        node.val += Math.max(Math.max(maxLeft, maxRight), 0);

        longestPath = Math.max(longestPath, node.val + Math.max(Math.min(maxLeft, maxRight), 0));

        return node.val;
    }
}
