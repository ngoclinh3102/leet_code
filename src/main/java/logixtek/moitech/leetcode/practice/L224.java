package logixtek.moitech.leetcode.practice;

public class L224 {

    public static void main(String[] args) {
//        System.out.println(calculate("1 + 1"));
//        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    private static int INDEX;

    public static int calculate(String s) {
        char[] sarray = s.toCharArray();
        INDEX = 0;
        return calc(sarray);
    }

    private static int calc(char[] sarray) {
        int sum = 0;
        int nextSign = 1;

        outerloop:
        while (INDEX < sarray.length) {
            switch (sarray[INDEX]) {
                case ' ' -> { }
                case '+' -> nextSign = 1;
                case '-' -> nextSign = -1;
                case '(' -> {
                    INDEX++;
                    sum += (nextSign * calc(sarray));
                }
                case ')' -> { break outerloop; }
                default -> {
                    int number = sarray[INDEX] - '0';
                    while (INDEX + 1 < sarray.length && sarray[INDEX+1] >= '0') {
                        INDEX++;
                        number = number * 10 + (sarray[INDEX] - '0');
                    }
                    sum += (nextSign * number);
                }
            }
            INDEX++;
        }
        return sum;
    }
}
