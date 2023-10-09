package logixtek.moitech.leetcode.practice;

public class L2038 {

    public static boolean winnerOfGame(String colors) {
        char[] colours = colors.toCharArray();
        int winner = 0;
        for (int i = 1; i + 1 < colours.length; i++) {
            if (colours[i] == colours[i-1] && colours[i] == colours[i+1]) {
                winner += (colours[i] == 'A' ? 1 : -1);
            }
        }
        return winner > 0;
    }
}
