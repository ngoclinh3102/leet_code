package logixtek.moitech.leetcode.practice.structure;

import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    Node dummyHead;
    Node cursor;

    public NestedIterator(List<NestedInteger> nestedList) {
        dummyHead = cursor = Node.of(0);
        reduce(nestedList);

        cursor = dummyHead;
    }

    private void reduce(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                cursor.next = Node.of(ni.getInteger());
                cursor = cursor.next;
            }
            else {
                reduce(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        cursor = cursor.next;
        return cursor.val;
    }

    @Override
    public boolean hasNext() {
        return cursor.next != null;
    }

    static class Node {
        int val;
        Node next;

        public Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public static Node of(int val) {
            return new Node(val, null);
        }
    }
}
