package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L006 {

    public static void main(String[] args) {
        System.out.println("PAYPALISHIRING"); System.out.println(convert("PAYPALISHIRING", 1));
        System.out.println("PYAIHRNAPLSIIG"); System.out.println(convert("PAYPALISHIRING", 2));
        System.out.println("PAHNAPLSIIGYIR"); System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println("PINALSIGYAHRPI"); System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) return s;

        StringBuilder zigzag = new StringBuilder();

        int n = s.length();
        int blocks = 2*(numRows-1);

        for (int i = 0; i < numRows; i++) {
            int j = blocks - i;
            int base = 0;
            while (true) {
                if (i + base * blocks < n) zigzag.append(s.charAt(i + base * blocks));
                else break;
                if (j != i && j != blocks) {
                    if (j + base * blocks < n) zigzag.append(s.charAt(j + base * blocks));
                    else break;
                }
                base++;
            }
        }

        return zigzag.toString();
    }

    public static String convert2(String s, int numRows) {
        if (s.length() <= 1 || numRows == 1) return s;

        char[][] board = new char[numRows][(s.length() + 1) / 2];

        int i = 0;
        int j = 0;
        boolean isDown = true;

        for (char c : s.toCharArray()) {
            board[i][j] = c;
            if (isDown) {
                i++;
                if (i == numRows) {
                    i = numRows - 2;
                    j++;
                    isDown = false;
                }
            }
            else {
                i--;
                j++;
                if (i < 0) {
                    i = 1;
                    j--;
                    isDown = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            for (char c : row) {
                if (c != '\u0000') sb.append(c);
            }
        }
        return sb.toString();
    }

    private static void p(char[][] deepArray) {
        for (char[] array : deepArray) {
            System.out.println(Arrays.toString(array));
        }
    }
}
