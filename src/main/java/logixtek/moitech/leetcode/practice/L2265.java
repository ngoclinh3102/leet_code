package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.TreeNode;

public class L2265 {
    public static void main(String[] args) {

    }

    private static int COUNT;

    public static int averageOfSubtree(TreeNode root) {
        COUNT = 0;
        postOrder(root);
        return COUNT;
    }

    private static int postOrder(TreeNode node) {
        if (node == null) return 0;

        int leftSize = postOrder(node.left);
        int rightSize = postOrder(node.right);

        int size = leftSize + rightSize + 1;
        int sum = node.val
                  + ((leftSize > 0) ? node.left.val : 0)
                  + ((rightSize > 0) ? node.right.val : 0);

        if (node.val == sum / size) COUNT++;

        node.val = sum;
        return size;
    }
}
