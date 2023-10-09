package logixtek.moitech.leetcode.practice;

public class L541 {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] sarray = s.toCharArray();

        for (int i = 0; i < n; i += 2*k) {
            revert(sarray, i, Math.min(i + k, n) -1 );
        }

        return String.valueOf(sarray);
    }

    private void revert(char[] sarray, int i, int j) {
        char temp;
        while (i < j) {
            temp = sarray[i];
            sarray[i] = sarray[j];
            sarray[j] = temp;
            i++;
            j--;
        }
    }
}
