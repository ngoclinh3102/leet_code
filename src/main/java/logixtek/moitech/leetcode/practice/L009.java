package logixtek.moitech.leetcode.practice;

public class L009 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(2_222_222)); // true
        System.out.println(isPalindrome(121)); // true
        System.out.println(isPalindrome(-121)); // false
        System.out.println(isPalindrome(10)); // false
        System.out.println(isPalindrome(0)); // true
        System.out.println(isPalindrome(5)); // true
        System.out.println(isPalindrome(-2_111_111_112)); // false
    }

    public static boolean isPalindrome(int x) {
        int num = 0;
        int temp = x;
        while (temp > 0) {
            num = 10 * num + temp % 10;
            temp /= 10;
        }
        return num == x;
    }
}
