package logixtek.moitech.leetcode.practice;

public class L779 {

    public static void main(String[] args) {
        System.out.println(kthGrammar(5, 14));
    }

    public static int kthGrammar(int n, int k) {
        if (n == 1) return 0;

        int length = 1 << (n - 2);

        return k <= length
               ? kthGrammar(n - 1, k)
               : 1 - kthGrammar(n - 1, k - length);
    }
}
