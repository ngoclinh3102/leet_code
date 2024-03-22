package logixtek.moitech.leetcode.practice;

import java.util.Arrays;

public class L043 {

    public static void main(String[] args) {
        System.out.println(multiply("16198", "49849"));
        System.out.println("807454102");
        System.out.println(Arrays.toString(toIntArrayAndReverse("807454102")));
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] m = toIntArrayAndReverse(num1);
        int[] n = toIntArrayAndReverse(num2);
        int[] prod =  new int[m.length + n.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < n.length; j++) {
                int p = m[i] * n[j];
                int k = 0;
                while (p > 0) {
                    p += prod[i+j+k];
                    prod[i+j+k] = p % 10;
                    p /= 10;
                    k++;
                }
            }
        }
        boolean f = false;
        StringBuilder builder = new StringBuilder();
        for (int i = prod.length - 1; i >= 0; i--) {
            f = f || prod[i] != 0;
            if (f) {
                builder.append(prod[i]);
            }
        }
        return builder.toString();
    }

    private static int[] toIntArrayAndReverse(String number) {
        int[] res = new int[number.length()];
        int i = res.length - 1;
        for (char c : number.toCharArray()) {
            res[i--] = c - '0';
        }
        return res;
    }
}
