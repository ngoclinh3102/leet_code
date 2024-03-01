package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.TreeNode;

public class L513 {

    public static void main(String[] args) {

    }

    public int findBottomLeftValue(TreeNode root) {
        int[] answer = {root.val, 0};
        inOrderTraverse(root, answer, 0);
        return answer[0];
    }

    private void inOrderTraverse(TreeNode node, int[] answer, int currentLevel) {
        if (node != null) {
            if (currentLevel > answer[1]) {
                answer[0] = node.val;
                answer[1] = currentLevel;
            }
            inOrderTraverse(node.left, answer, currentLevel + 1);
            inOrderTraverse(node.right, answer, currentLevel + 1);
        }
    }
}
