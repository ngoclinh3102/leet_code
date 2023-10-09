package logixtek.moitech.leetcode.practice;

public class L008 {

    public static void main(String[] args) {
        System.out.println(myAtoi("-000000000000001"));
//        System.out.println(myAtoi("-42"));
//        System.out.println(myAtoi("+42"));
//        System.out.println(myAtoi("+e42"));
//        System.out.println(myAtoi("e+42"));
//        System.out.println(myAtoi("1+42"));
    }

    public static int myAtoi(String s) {
        var array = s.toCharArray();
        int sign = 1;

        int i = 0;
        while (i < array.length && (array[i] == ' ' || array[i] == '+' || array[i] == '-')) {
            if (array[i] == '+' || array[i] == '-') {
                if (array[i++] == '-') sign = -1;
                break;
            }
            i++;
        }

        long number = 0;
        while (i < array.length && array[i] >= '0' && array[i] <= '9') {
            number = number * 10 + (array[i] - '0');
            if (sign == 1 && number > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && number - 1 > Integer.MAX_VALUE) return Integer.MIN_VALUE;
            i++;
        }

        return (int) number * sign;
    }
}
