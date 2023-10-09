package logixtek.moitech.leetcode.practice;

public class L2516 {

    public static void main(String[] args) {
        System.out.println(takeCharacters("aabaaaacaabc", 2));
    }

    public static int takeCharacters(String s, int k) {
        var sarray = s.toCharArray();

        int[] occurs = new int[3];
        for (char ch : sarray) {
            occurs[ch - 'a']++;
        }

        if (occurs[0] < k || occurs[1] < k || occurs[2] < k) return -1;

        int left = 0;
        int right = 0;
        int maxRemaining = 0;
        while (left < sarray.length) {
            while (right < sarray.length && occurs[sarray[right] - 'a'] > k) {
                occurs[sarray[right] - 'a']--;
                right++;
            }

            if (occurs[0] < k || occurs[1] < k || occurs[2] < k) break;

            if (maxRemaining < right - left) {
                maxRemaining = right - left;
            }

            occurs[sarray[left] - 'a']++;
            left++;
        }

        return sarray.length - maxRemaining;
    }
}
