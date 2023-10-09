package logixtek.moitech.leetcode.practice;

public class L2483 {

    public static void main(String[] args) {
        System.out.println(bestClosingTime("YYNY")); // 2
        System.out.println(bestClosingTime("NNNNN")); // 0
        System.out.println(bestClosingTime("YYYY")); // 4
    }

    public static int bestClosingTime(String customers) {
        int penalty = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') penalty++;
        }

        if (penalty == 0) return 0;

        int bestHour = 0;
        int minPenalty = penalty;

        for (int i = 0; i < customers.length(); i++) {
            penalty = penalty - ((customers.charAt(i) == 'Y') ? 1 : -1);
            if (penalty <= 0) return (i+1);
            if (penalty < minPenalty) {
                bestHour = i+1;
                minPenalty = penalty;
            }
        }

        return bestHour;
    }

    public static int bestClosingTime2(String customers) {
        int[] penalties = new int[customers.length()+1];

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalties[0]++;
                penalties[i+1] = 1;
            }
            else {
                penalties[i+1] = -1;
            }
        }

        int bestHour = 0;
        if (penalties[bestHour] == 0) return bestHour;

        for (int i = 1; i < penalties.length; i++) {
            penalties[i] = penalties[i-1] - penalties[i];
            if (penalties[i] <= 0) return i;
            if (penalties[i] < penalties[bestHour]) bestHour = i;
        }

        return bestHour;
    }
}
