package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.structure.Node;

import java.util.HashMap;

public class L138 {

    public static Node copyRandomList(Node head) {
        var map = new HashMap<Node, Node>();

        var pointer = head;
        while (pointer != null) {
            map.put(pointer, new Node(pointer.val));
            pointer = pointer.next;
        }

        pointer = head;
        while (pointer != null) {
            map.get(pointer).next = map.get(pointer.next);
            map.get(pointer).random = map.get(pointer.random);
            pointer = pointer.next;
        }

        return map.get(head);
    }
}
