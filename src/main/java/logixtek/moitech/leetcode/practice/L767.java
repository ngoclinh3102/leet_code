package logixtek.moitech.leetcode.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class L767 {

    public static void main(String[] args) {
        String s1 = reorganizeString("aaaaaqwert");
        System.out.println(s1);
    }

    public static String reorganizeString(String s) {
        StringBuilder ans = new StringBuilder();

        int[] occurrences = new int[26];
        for (char ch : s.toCharArray()) occurrences[ch - 'a']++;

        Queue<Character> queue = new PriorityQueue<>(Comparator.comparingInt(ch -> - occurrences[ch - 'a']));
        for (int ch = 0; ch < 26; ch++) {
            if (occurrences[ch] > 0) queue.add((char) (ch + 'a'));
        }

        char ch;
        while (!queue.isEmpty()) {
            ch = queue.poll();

            if (!ans.isEmpty() && ch == ans.charAt(ans.length() - 1)) {
                if (queue.isEmpty()) return "";
                var temp = ch;
                ch = queue.poll();
                queue.add(temp);
            }
            ans.append(ch);
            occurrences[ch - 'a']--;
            if (occurrences[ch - 'a'] > 0) queue.add(ch);
        }

        return ans.toString();
    }
}
