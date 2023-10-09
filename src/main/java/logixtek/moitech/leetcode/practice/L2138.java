package logixtek.moitech.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class L2138 {
    public static void main(String[] args) {
        String[] sarray = divideString("abcdefghi", 3, 'x');
        System.out.println(Arrays.toString(sarray));
    }

    public static String[] divideString(String s, int k, char fill) {
        for (int i = 0; i + 1 < k; i++) s = s.concat(String.valueOf(fill));
        var sarray = new String[s.length() / k];
        for (int i = 0; i < sarray.length; i++) sarray[i] = s.substring(i * k, (i + 1) * k);
        return sarray;
    }

    public static String[] divideString2(String s, int k, char fill) {
        for (int i = 0; i + 1 < k; i++) {
            s = s.concat(String.valueOf(fill));
        }
        var list = new ArrayList<String>();
        int i = 0;
        while (i + k - 1 < s.length()) {
            list.add(s.substring(i, i + k));
            i += k;
        }
        return list.toArray(new String[0]);
    }
}
