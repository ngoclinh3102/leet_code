package logixtek.moitech.leetcode.practice;

public class L2433 {

    public static void main(String[] args) {
    }

    public static int[] findArray(int[] pref) {
        int n = pref.length;
        int[] answer = new int[n];

        answer[0] = pref[0];
        for (int i = 1; i < n; i++) {
            answer[i] = pref[i-1] ^ pref[i];
        }

        return answer;
    }
}
