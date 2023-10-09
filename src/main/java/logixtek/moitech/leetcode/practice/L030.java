package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L030 {

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoofoobarthefoobarman", "bar","foo","the")); // [6,9,12]
        System.out.println(findSubstring("wordgoodgoodgoodbestword", "word","good","best","good")); // [8]
    }

    public static List<Integer> findSubstring(String s, String... words) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> map;
        Map<String, Integer> originalMap = new HashMap<>();
        for (String w : words) originalMap.merge(w, 1, Integer::sum);

        int size = words[0].length();
        int len = size * words.length;

        boolean[] isBadPos = new boolean[s.length()];
        for (int i = isBadPos.length - size; i >= 0; i--) {
            if (!isBadPos[i] && !originalMap.containsKey(s.substring(i, i + size))) {
                for (int j = 0; j < words.length && j * size <= i; j++) {
                    isBadPos[i - j * size] = true;
                }
            }
        }

        for (int i = 0; i + len <= s.length() ; i++) {
            if (!isBadPos[i]) {
                map = new HashMap<>(originalMap);
                int j = i;
                while (j < i + len) {
                    int count;
                    String current = s.substring(j, j + size);
                    if ((count = map.getOrDefault(current, 0)) > 0) {
                        map.put(current, count - 1);
                        j += size;
                    }
                    else {
                        break;
                    }
                }
                map.clear();
                if (j == i + len) answer.add(i);
            }
        }

        return answer;
    }
}
