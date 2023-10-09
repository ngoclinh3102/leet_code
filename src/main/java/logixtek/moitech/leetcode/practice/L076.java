package logixtek.moitech.leetcode.practice;

public class L076 {

    public static void main(String[] args) {
        String s = "ugnesbfyqwerlfshakdouigtatfhsaltufgwhqjedrwueq";
        String t = "agd";
        String result = minWindow(s, t);
        for (var ch : result.toCharArray()) {
            System.out.print(t.indexOf(ch) != -1 ? String.valueOf(ch).toUpperCase() : ch);
        }
    }

    public static String minWindow(String s, String t) {

        int tsum = 0;
        int[] occurrences = new int[128];
        boolean[] exist = new boolean[128];

        for (char tchar : t.toCharArray()) {
            exist[tchar] = true;
            occurrences[tchar]--;
            tsum += tchar;
        }

        char[] sarray = s.toCharArray();
        int minLen = sarray.length;
        int minIndex = -1;

        int left = 0;
        int right = 0;
        int checkSum = 0;
        while (true) {
            while (checkSum < tsum && right < sarray.length) {
                if (exist[sarray[right]]) {
                    occurrences[sarray[right]]++;
                    if (occurrences[sarray[right]] <= 0) {
                        checkSum += sarray[right];
                    }
                }
                right++;
            }

            if (checkSum < tsum) break;

            while (left < right) {
                if (exist[sarray[left]]) {
                    occurrences[sarray[left]]--;
                    if (occurrences[sarray[left]] < 0) {
                        checkSum -= sarray[left];
                        break;
                    }
                }
                left++;
            }

            if (right - left <= minLen) {
                minLen = right - left;
                minIndex = left;
            }

            left++;
        }

        return minIndex != -1 ? s.substring(minIndex, minIndex + minLen) : "";
    }
}