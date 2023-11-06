package logixtek.moitech.leetcode.practice;

import java.util.LinkedList;
import java.util.List;

public class L1441 {
    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{1,2,3}, 3));
    }

    public static List<String> buildArray(int[] target, int n) {
        final String POP = "Pop";
        final String PUSH = "Push";

        List<String> answer = new LinkedList<>();

        int index = 0;
        for (int i = 1; i <= n && index < target.length; i++) {
            if (i == target[index]) {
                answer.add(PUSH);
                index++;
            }
            else {
                answer.add(PUSH);
                answer.add(POP);
            }
        }

        return answer;
    }
}
