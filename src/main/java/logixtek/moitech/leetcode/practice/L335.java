package logixtek.moitech.leetcode.practice;

public class L335 {
    public static void main(String[] args) {

    }

    public static boolean isSelfCrossing(int[] distance) {
        if (distance.length <= 3) {
            return false;
        }

        for (int i = 3; i < distance.length; i++) {
            boolean case1 = distance[i] >= distance[i-2]
                            && distance[i-1] <= distance[i-3];

            boolean case2 = i >= 4
                            && distance[i-1] == distance[i-3]
                            && distance[i] + distance[i-4] >= distance[i-2];

            boolean case3 = i >= 5
                            && distance[i-2] >= distance[i-4]
                            && distance[i-2] <= distance[i-4] + distance[i]
                            && distance[i-3] >= distance[i-1]
                            && distance[i-3] <= distance[i-1] + distance[i-5];

            if (case1 || case2 || case3) return true;
        }

        return false;
    }
}
