package logixtek.moitech.leetcode.practice;

public class L168 {

    public static void main(String[] args) {
        for (int i = 1; i < 64; i++) {
            System.out.println(i + "\t\t" + convertToTitle(i));
        }
    }

    private static final char[] CHARACTERS = {'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'};

    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();

        while (columnNumber > 0) {
            ans.insert(0, CHARACTERS[columnNumber % 26]);
            columnNumber = (columnNumber - 1) / 26;
        }

        return ans.toString();
    }
}