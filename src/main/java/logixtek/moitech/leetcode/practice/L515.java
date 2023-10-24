package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L515 {

    public static void main(String[] args) {
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> largestInRow = new ArrayList<>();
        traverse(largestInRow, root, 0);
        return largestInRow;
    }

    private static void traverse(List<Integer> largestInRow, TreeNode node, int height) {
        if (node != null) {
            if (height == largestInRow.size()) {
                largestInRow.add(node.val);
            }
            else if (largestInRow.get(height) < node.val) {
                largestInRow.set(height, node.val);
            }

            traverse(largestInRow, node.left, height + 1);
            traverse(largestInRow, node.right, height + 1);
        }
    }
}
