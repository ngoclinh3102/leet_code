package logixtek.moitech.leetcode.practice;

import logixtek.moitech.leetcode.practice.models.Trie;

public class L208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("trie.insert(\"apple\")"); trie.insert("apple");
        System.out.println("trie.search(\"apple\"): " + trie.search("apple"));
        System.out.println("trie.search(\"app\"): " + trie.search("app"));
        System.out.println("trie.startsWith(\"app\"): " + trie.startsWith("app"));
        System.out.println("trie.insert(\"app\")"); trie.insert("app");
        System.out.println("trie.search(\"app\"): " + trie.search("app"));
        System.out.println("trie.search(\"\"): " + trie.search(""));
        System.out.println("trie.insert(\"\")"); trie.insert("");
        System.out.println("trie.search(\"\"): " + trie.search(""));
    }
}
