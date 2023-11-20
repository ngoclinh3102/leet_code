package logixtek.moitech.leetcode.practice;

public class L551 {
    public static void main(String[] args) {

    }

    public static boolean checkRecord(String s) {
        int absCount = 0;
        int lateCount = 0;

        for (char record : s.toCharArray()) {
            if (record == 'L') {
                lateCount++;
            }
            else {
                lateCount = 0;
                if (record == 'A') {
                    absCount++;
                }
            }

            if (absCount == 2 || lateCount == 3) return false;
        }

        return true;
    }
}
