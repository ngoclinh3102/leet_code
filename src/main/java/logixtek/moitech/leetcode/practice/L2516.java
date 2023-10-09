package logixtek.moitech.leetcode.practice;

import java.util.HashMap;

public class L2516 {

    public static void main(String[] args) {
        // TODO
        System.out.println(takeCharacters("aabaaaacaabc", 2));
    }

    public static int takeCharacters(String s, int k) {
        var sarray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('b',0);
        map.put('c',0);
        for (char c : sarray) map.put(c, map.get(c) + 1);
        if (!isKOfEachCharacter(map, k)) return -1;
        int i = 0;
        int j = 0;
        return 0;
    }

    private static boolean isKOfEachCharacter(HashMap<Character, Integer> map, int k) {
        return map.get('a') >= k && map.get('b') >= k && map.get('c') >= k;
    }
}
