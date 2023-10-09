package logixtek.moitech.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class L013 {

    public static void main(String[] args) {

    }

    public static int romanToInt(String s) {
        char[] sarray = s.toCharArray();
        int dumber = 0;
        int prevValue = 0;
        for (int i = sarray.length - 1; i >= 0; i--) {
            int value = switch (sarray[i]) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            if (value < prevValue) dumber -= value;
            else dumber += value;
            prevValue = value;
        }
        return dumber;
    }

    private static Map<Character, Integer> romanNumeralMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map;
    }
}
