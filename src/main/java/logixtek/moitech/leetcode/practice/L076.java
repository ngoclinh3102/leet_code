package logixtek.moitech.leetcode.practice;

import java.util.HashMap;

public class L076 {

    public static void main(String[] args) {
        // TODO
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public static String minWindow(String s, String t) {
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();

        int tsum = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tarray) {
            map.merge(c, -1, Integer::sum);
            tsum += c;
        }

        int checkSum = 0;
        int minIndex = 0;
        int minLen = sarray.length;

        int left = 0;
        int right = 0;

        while (true) {
            while (checkSum < tsum && right < sarray.length) {
                if (map.containsKey(sarray[right])) {
                    if (map.get(sarray[right]) < 0) {
                        checkSum += tsum;
                    }
                    map.merge(sarray[right], 1, Integer::sum);
                }
                right++;
            }

            if (checkSum < tsum) break;

            while (left < right) {
                if (map.containsKey(sarray[left])) {
                    if (map.get(sarray[left]) == 0) break;
                    else map.merge(sarray[left], -1, Integer::sum);
                }
                left++;
            }

            if (right - left < minLen) {
                minLen = right - left;
                minIndex = left;
            }

            checkSum -= sarray[left];
            left++;
        }

        return String.valueOf(sarray, minIndex, minLen);
    }
}