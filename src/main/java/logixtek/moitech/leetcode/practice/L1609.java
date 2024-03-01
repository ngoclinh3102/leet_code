package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.TreeNode;

import java.util.LinkedList;

public class L1609 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        System.out.println(isEvenOddTree(root));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isEvenHeight = true;
        while (queue.size() > 0) {
            TreeNode prev = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (isEvenHeight) {
                    if (current.val % 2 == 0) return false;
                    if (prev != null && prev.val >= current.val) return false;
                }
                else {
                    if (current.val % 2 == 1) return false;
                    if (prev != null &&  prev.val <= current.val) return false;
                }
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                prev = current;
            }
            isEvenHeight = !isEvenHeight;
        }

        return true;
    }

    public static boolean isEvenOddTree2(TreeNode root) {
        int[] heightValue = new int[100_000];
        for (int i = 1; i < 100_000; i += 2) heightValue[i] = 2_000_000;

        return traverse(root, heightValue, 0);
    }

    private static boolean traverse(TreeNode node, int[] heightValue, int height) {
        if (node == null) return true;

        if (height % 2 == 0 && (node.val % 2 == 0 || heightValue[height] >= node.val)) return false;
        if (height % 2 == 1 && (node.val % 2 != 0 || heightValue[height] <= node.val)) return false;

        heightValue[height] = node.val;

        return traverse(node.left, heightValue, height + 1) && traverse(node.right, heightValue, height + 1);
    }
}
