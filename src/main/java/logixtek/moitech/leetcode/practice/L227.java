package logixtek.moitech.leetcode.practice;

import java.util.LinkedList;

public class L227 {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }

    public static int calculate(String s) {
        char[] sarray = s.toCharArray();

        LinkedList<Integer> list = new LinkedList<>();

        char sign = '+';
        for (int i = 0; i < sarray.length; i++) {
            if (sarray[i] >= '0') {
                int number = sarray[i] - '0';
                while (i + 1 < sarray.length && sarray[i+1] >= '0') {
                    i++;
                    number = 10 * number + (sarray[i] - '0');
                }
                switch (sign) {
                    case '+' -> list.addLast(number);
                    case '-' -> list.addLast(-number);
                    case '*' -> list.addLast(list.removeLast() * number);
                    case '/' -> list.addLast(list.removeLast() / number);
                }
            }
            else if (sarray[i] >= '*') {
                sign = sarray[i];
            }
        }

        int result = 0;
        for (int num : list) {
            result += num;
        }

        return result;
    }
}
