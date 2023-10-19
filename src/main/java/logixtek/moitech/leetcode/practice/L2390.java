package logixtek.moitech.leetcode.practice;

public class L2390 {

    public static void main(String[] args) {
    }

    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        int starCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (starCount > 0 || ch == '*') {
                if (ch == '*') {
                    starCount++;
                }
                else {
                    starCount--;
                }
                continue;
            }

            sb.append(ch);
        }

        return sb.reverse().toString();
    }
}
