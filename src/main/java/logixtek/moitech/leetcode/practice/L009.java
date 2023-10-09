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
        if (x < 0) return false;
        int size = 0;
        while (x >= Math.pow(10, ++size));
        while (x > 0) {
            if ((int) (x / Math.pow(10, size-1)) != (x % 10)) return false;
            size -= 2;
            x /= 10;
            x %= Math.pow(10, size);
        }
        return true;
    }
}
