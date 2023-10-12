package logixtek.moitech.leetcode.practice;

public class L2038 {

    public static boolean winnerOfGame(String colors) {
        char[] colours = colors.toCharArray();

        int AliceWin = 0;
        for (int i = 1; i + 1 < colours.length; i++) {
            if (colours[i] == colours[i-1] && colours[i] == colours[i+1]) {
                if (colours[i] == 'A') {
                    AliceWin++;
                }
                else {
                    AliceWin--;
                }
            }
        }

        return AliceWin > 0;
    }
}
