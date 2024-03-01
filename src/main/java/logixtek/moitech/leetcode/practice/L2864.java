package logixtek.moitech.leetcode.practice;

public class L2864 {
    public static void main(String[] args) {

    }

    public String maximumOddBinaryNumber(String s) {
        int[] binary = new int[s.length()];

        int index = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                binary[index++] = 1;
            }
        }

        binary[index-1] = 0;
        binary[binary.length-1] = 1;

        StringBuilder sb = new StringBuilder();
        for (int c : binary) sb.append(c);

        return sb.toString();
    }
}
