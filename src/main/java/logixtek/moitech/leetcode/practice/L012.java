package logixtek.moitech.leetcode.practice;

public class L012 {

    public static void main(String[] args) {
        System.out.println(intToRoman(3)); // III
        System.out.println(intToRoman(58)); // LVIII
        System.out.println(intToRoman(1994)); // MCMXCIV
    }

    private static final char[][] ROMANNUMERAL = {
            {'I', 'V'}, // 1
            {'X', 'L'}, // 10
            {'C', 'D'}, // 100
            {'M', '?'}, // 1000
            {'?', '?'}, // ...
    };

    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();

        int i = ROMANNUMERAL.length - 1;
        int step = (int) Math.pow(10, i);

        while (num > 0) {
            if (num >= 9 * step) {
                roman.append(ROMANNUMERAL[i][0]).append(ROMANNUMERAL[i+1][0]);
                num -= 9 * step;
            }
            else if (num >= 5 * step) {
                roman.append(ROMANNUMERAL[i][1]);
                num -= 5 * step;
            }
            else if (num >= 4 * step) {
                roman.append(ROMANNUMERAL[i][0]).append(ROMANNUMERAL[i][1]);
                num -= 4 * step;
            }
            while (num >= step) {
                roman.append(ROMANNUMERAL[i][0]);
                num -= step;
            }
            i--;
            step /= 10;
        }

        return roman.toString();
    }
}
