package logixtek.moitech.leetcode.practice.structure;

public class MyHashMap {
    protected final int CAPACITY = 10_000;
    protected int HASHSIZE = 2;
    protected int size = 0;
    Node[] nodes;

    static class Node{
        final int key;
        int value;
        Node next;
        
        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        
        public static Node of(int key, int value, Node next) {
            return new Node(key, value, next);
        }
    }

    public MyHashMap() {
        nodes = new Node[HASHSIZE];
    }

    public void put(int key, int value) {
        final int hashcode = hash(key);

        Node node = nodes[hashcode];
        while (node != null && node.key != key) {
            node = node.next;
        }

        if (node != null) {
            node.value = value;
            return;
        }

        if (size == CAPACITY) {
            throw new IndexOutOfBoundsException();
        }

        node = Node.of(key, value, nodes[hashcode]);
        nodes[hashcode] = node;
        size++;
    }

    public int get(int key) {
        Node node = nodes[hash(key)];

        while (node != null && node.key != key) {
            node = node.next;
        }
        return node != null ? node.value : -1;
    }

    public void remove(int key) {
        final int hashcode = hash(key);

        Node node = nodes[hashcode];
        if (node != null && node.key == key) {
            nodes[hashcode] = node.next;
            return;
        }

        Node prevNode = Node.of(0,0,node);
        while (node != null && node.key != key) {
            prevNode = prevNode.next;
            node = node.next;
        }

        if (node != null) {
            prevNode.next = node.next;
            size--;
        }
    }

    protected final int hash(int key) {
        return key % HASHSIZE;
    }
}
