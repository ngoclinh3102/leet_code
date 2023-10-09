package logixtek.moitech.leetcode.practice;

public class L065 {
    public static void main(String[] args) {
        tens:
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                int num = 10 * i + j;
                if (num == 20) break tens;
                System.out.println(num);
            }
        }
    }

    public boolean isNumber(String s) {
        int l = s.length();
        if (s.equals("Infinity")
            || s.equals("-Infinity")
            || s.equals("+Infinity")
            || s.charAt(l - 1) == 'f'
            || s.charAt(l - 1) == 'd'
            || s.charAt(l - 1) == 'D'
            || s.charAt(l - 1) == 'F') {
            return false;
        }
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
