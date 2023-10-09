package logixtek.moitech.leetcode.practice;

public class L1647 {

    public static void main(String[] args) {
        System.out.println(minDeletions("aab")); // 0
        System.out.println(minDeletions("aaabbbcc")); // 2
        System.out.println(minDeletions("ceabaacb")); // 2
    }

    public static int minDeletions(String s) {
        int deletions = 0;

        int[] frequencies = new int[26];
        for (char c : s.toCharArray()) frequencies[c - 'a']++;

        boolean[] exist = new boolean[10_000];
        for (int i = 0; i < 26; i++) {
            while (frequencies[i] > 0 && exist[frequencies[i]]) {
                frequencies[i]--;
                deletions++;
            }
            exist[frequencies[i]] = true;
        }

        return deletions;
    }
}
