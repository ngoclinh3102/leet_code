package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class L501 {
    public static void main(String[] args) {
        int[] res = findMode(TreeNode.of(2, TreeNode.of(1), TreeNode.of(3)));
        System.out.println(Arrays.toString(res));
    }

    public static int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();

        traverse(root, map);

        int mode = 1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value >= mode) {
                if (value > mode) {
                    list = new LinkedList<>();
                    mode = value;
                }
                list.add(key);
            }
        }

        int i = 0;
        int[] ans = new int[list.size()];
        for (int key : list) ans[i++] = key;

        return ans;
    }

    private static void traverse(TreeNode node, HashMap<Integer, Integer> map) {
        if (node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            traverse(node.left, map);
            traverse(node.right, map);
        }
    }
}
