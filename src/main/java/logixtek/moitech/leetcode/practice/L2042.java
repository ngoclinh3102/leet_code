package logixtek.moitech.leetcode.practice;

public class L2042 {

    public static void main(String[] args) {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }

    public static boolean areNumbersAscending(String s) {
        int len = s.length(); s.toCharArray();

        int prevNumber;
        int currNumber = 0;
        for (int i = 0; i < len; i++) {

            while (i < len && !isDigit(s.charAt(i))) i++;

            prevNumber = currNumber;
            currNumber = 0;
            while (i < len && isDigit(s.charAt(i))) {
                currNumber = currNumber * 10 + (s.charAt(i) - '0');
                i++;
            }

            if (currNumber > 0 && currNumber <= prevNumber) {
                return false;
            }
        }

        return true;
    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
