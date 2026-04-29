package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

/**
 * @author ngoclinh
 */
public class L1769 {

    public int[] minOperations(String boxes) {
        char[] boxess = boxes.toCharArray();
        int[] res = new int[boxess.length];

        int count = 0;
        int moveCount = 0;
        for (int i = 0; i < boxess.length; i++) {
            res[i] += moveCount;
            if (boxess[i] == '1') {
                count++;
            }
            moveCount += count;
        }

        count = 0;
        moveCount = 0;
        for (int i = boxess.length - 1; i >= 0; i--) {
            res[i] += moveCount;
            if (boxess[i] == '1') {
                count++;
            }
            moveCount += count;
        }

        return res;
    }

    public static void main(String[] args) {
        L1769 solution = new L1769();
        int[] res = solution.minOperations("001011");
        System.out.println(Arrays.toString(res));
    }
}
